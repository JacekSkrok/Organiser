package pl.jacek.api.consts;

import pl.jacek.api.model.Meeting;
import pl.jacek.api.model.RegisterUserRequest;
import pl.jacek.api.model.User;
import pl.jacek.security.annotation.Authenticate;

import javax.persistence.Persistence;
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
        Persistence.createEntityManagerFactory("manager").createEntityManager();
        return Response.status(Response.Status.OK).entity("twoj user").build();
    }

    @Authenticate
    @POST
    @Path(ApiEndpoints.MEETING_ALL)
    public Response postMeeting(Meeting body) {
        return Response.status(Response.Status.OK).entity("Dodano spotkanie").build();
    }

    @Authenticate
    @GET
    @Path(ApiEndpoints.MEETING_ALL)
    public Response getMeeting(
            User body,
            @QueryParam(ApiEndpoints.PARAM_LIMIT) Integer limit,
            @QueryParam(ApiEndpoints.PARAM_OFFSET) Integer offset,
            @QueryParam(ApiEndpoints.PARAM_SEARCH) String search

    ) {
        return Response.status(Response.Status.OK).entity("mock call ok").build();
    }
}
