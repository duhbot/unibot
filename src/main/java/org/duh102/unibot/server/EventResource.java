package org.duh102.unibot.server;
import org.duh102.unibot.model.events.MessageEvent;
import org.duh102.unibot.model.MessageResponse;
import org.duh102.unibot.model.events.PrivateMessageEvent;
import org.duh102.unibot.plugin.MessageEventListener;
import org.duh102.unibot.plugin.PrivateMessageEventListener;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/event")
public class EventResource {
    private List<MessageEventListener> messageEventListeners;
    private List<PrivateMessageEventListener> privateMessageEventListeners;

    public EventResource(List<MessageEventListener> messageEventListeners,
                         List<PrivateMessageEventListener> privateMessageEventListeners) {
        this.messageEventListeners = messageEventListeners;
        this.privateMessageEventListeners = privateMessageEventListeners;
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/message")
    public Response processEvent(MessageEvent event) {
        List<MessageResponse> responses = new ArrayList<>();
        for(MessageEventListener listener : messageEventListeners) {
            if(listener.respondsToEvent(event)) {
                responses.add(listener.onMessage(event));
            }
        }
        return Response.status(200).entity(responses).build();
    }
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/private-message")
    public Response processEvent(PrivateMessageEvent event) {
        List<MessageResponse> responses = new ArrayList<>();
        for(PrivateMessageEventListener listener : privateMessageEventListeners) {
            if(listener.respondsToEvent(event)) {
                responses.add(listener.onPrivateMessage(event));
            }
        }
        return Response.status(200).entity(responses).build();
    }
}
