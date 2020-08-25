package org.duh102.unibot.server;
import org.duh102.unibot.model.events.MessageEvent;
import org.duh102.unibot.model.MessageResponse;
import org.duh102.unibot.model.RichText;
import org.duh102.unibot.model.RichTextComponent;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/event")
public class MessageResource {
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/")
    public Response processEvent(MessageEvent event) {
        List<RichTextComponent> messageComponents = new ArrayList<>();
        messageComponents.add(new RichTextComponent("I'm responding to your message: '"));
        messageComponents.addAll(event.getMessage().getComponents());
        messageComponents.add(new RichTextComponent("'; isn't that neat?"));
        MessageResponse response = new MessageResponse(new RichText(messageComponents));
        return Response.status(200).entity(response).build();
    }
}
