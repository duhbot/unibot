package org.duh102.unibot.server;
import org.duh102.unibot.model.MessageResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/event")
public class MessageResource {
    @GET
    @Produces("application/json")
    @Path("/")
    public Response processEvent()
    {
        MessageResponse response = new MessageResponse("Hello world!");
        return Response.status(200).entity(response).build();
    }

}
