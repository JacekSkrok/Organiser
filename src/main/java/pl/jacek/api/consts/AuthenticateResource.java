package pl.jacek.api.consts;

import io.swagger.model.AuthenticationResponse;
import org.apache.commons.lang3.StringUtils;
import pl.jacek.api.handlers.ErrorHandler;
import pl.jacek.api.model.AuthenticationRequest;
import pl.jacek.exceptions.UnauthenticatedException;
import pl.jacek.exceptions.ValidationException;
import pl.jacek.model.UserAccountEntity;
import pl.jacek.repository.impl.ApiTokenRepository;
import pl.jacek.repository.impl.UserAccountRepository;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(ApiEndpoints.AUTHENTICATE)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthenticateResource {
    @POST
    public Response postAuthenticate(AuthenticationRequest body) {
        try {
            if (body == null) {
                throw new ValidationException("No request data provided");
            }
            if ((StringUtils.isBlank(body.getEmail())) || StringUtils.isBlank(body.getPassword())) {
                throw new ValidationException("No credentials data provided");
            }
            UserAccountRepository userAccountRepository = new UserAccountRepository();
            UserAccountEntity userAccountEntity = userAccountRepository.findByEmail(body.getEmail());
            if (userAccountEntity == null) {
                throw new UnauthenticatedException();
            }
            if (!userAccountEntity.validatePass(body.getPassword())) {
                throw  new  UnauthenticatedException();
            }
            ApiTokenRepository apiTokenRepository = new ApiTokenRepository();
            return Response.status(Response.Status.OK)
                    .entity(
                            AuthenticationResponse.createFromApiToken(
                                    apiTokenRepository.generateApiToken(
                                            userAccountEntity
                                    )
                            )
                    ).build();
        } catch (UnauthenticatedException ex) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity(
                            ErrorHandler.getErrorResponse(ex)
                    ).build();
        } catch (ValidationException ex) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(
                            ErrorHandler.getErrorResponse(ex)
                    ).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(
                            ErrorHandler.getErrorResponse(ex)
                    ).build();
        }
    }
}
