package org.duh102.unibot.server.resources;

import org.duh102.unibot.model.text.MessageResponse;
import org.duh102.unibot.model.events.MessageEvent;
import org.duh102.unibot.model.events.PrivateMessageEvent;
import org.duh102.unibot.model.plugin.MessageEventListener;
import org.duh102.unibot.model.plugin.PrivateMessageEventListener;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/event")
public class EventResource {
    private final List<MessageEventListener> messageEventListeners;
    private final List<PrivateMessageEventListener> privateMessageEventListeners;

    public EventResource() {
        this(new ArrayList<>(), new ArrayList<>());
    }
    public EventResource(List<MessageEventListener> messageEventListeners,
                         List<PrivateMessageEventListener> privateMessageEventListeners) {
        this.messageEventListeners = messageEventListeners;
        this.privateMessageEventListeners = privateMessageEventListeners;
    }

    public void setMessageEventListeners(List<MessageEventListener> newListeners) {
        messageEventListeners.clear();
        messageEventListeners.addAll(newListeners);
    }
    public void clearMessageEventListeners() {
        messageEventListeners.clear();
    }

    public void setPrivateMessageEventListeners(List<PrivateMessageEventListener> newListeners) {
        privateMessageEventListeners.clear();
        privateMessageEventListeners.addAll(newListeners);
    }
    public void clearPrivateMessageEventListeners() {
        privateMessageEventListeners.clear();
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
