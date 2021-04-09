package pl.jacek.api.consts;

import pl.jacek.api.model.RegisterUserRequest;
import pl.jacek.api.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(ApiEndpoints.USER)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    @POST
    public Response postUser(RegisterUserRequest body) {

        return Response.status(Response.Status.OK).entity("zalogowano").build();
    }

    @GET
    public Response getUser(User body) {

        return Response.status(Response.Status.OK).entity("mock ok").build();
    }
}
