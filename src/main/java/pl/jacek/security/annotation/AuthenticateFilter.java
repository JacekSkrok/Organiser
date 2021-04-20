package pl.jacek.security.annotation;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import pl.jacek.api.handlers.ErrorHandler;
import pl.jacek.exceptions.UnauthenticatedException;
import pl.jacek.model.ApiTokenEntity;
import pl.jacek.model.UserAccountEntity;
import pl.jacek.repository.EntityManagerHelper;
import pl.jacek.repository.impl.ApiTokenRepository;
import pl.jacek.security.OrganiserAppSecurityContext;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;
import java.util.Date;

@Authenticate
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticateFilter implements ContainerRequestFilter {

    @Context
    UriInfo uriInfo;

    @Override
    public void filter(ContainerRequestContext requestContext) {
        final String AUTH_HEADER_BEARER = "Bearer: ";
        try {
            String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
            if (StringUtils.isBlank(authorizationHeader)) {
                throw new UnauthenticatedException("No authorization data provided...");
            }
            if (!authorizationHeader.startsWith(AUTH_HEADER_BEARER)) {
                throw new UnauthenticatedException("Wrong format of authorization data...");
            }
            requestContext.setSecurityContext(
                    new OrganiserAppSecurityContext(
                            validateToken(
                                    authorizationHeader.substring(AUTH_HEADER_BEARER.length()).trim()
                            ),
                            uriInfo
                    )
            );
        } catch (UnauthenticatedException ex) {
            requestContext.abortWith(
                    Response.status(Response.Status.UNAUTHORIZED).entity(ErrorHandler.getErrorResponse(ex)).build()
            );
        }
    }

    private UserAccountEntity validateToken(String accessToken) throws UnauthenticatedException {
        final int TOKEN_VALIDATION_MINUTES = 30;
        if (StringUtils.isBlank(accessToken)) {
            throw new UnauthenticatedException();
        }
        ApiTokenEntity apiTokenEntity = ApiTokenRepository.findbyAccessToken(accessToken);
        if (apiTokenEntity == null) {
            throw new UnauthenticatedException();
        }
        if (apiTokenEntity.getUserAccountEntity() == null) {
            throw new UnauthenticatedException();
        }
        EntityManagerHelper.startTransaction();
        ApiTokenRepository tokenRepository = new ApiTokenRepository();
        apiTokenEntity.setValidTo(
                DateUtils.addMinutes(
                        new Date(),
                        TOKEN_VALIDATION_MINUTES
                )
        );
        apiTokenEntity.setValidTo(DateUtils.addMinutes(new Date(), TOKEN_VALIDATION_MINUTES));
        tokenRepository.merge(apiTokenEntity);
        EntityManagerHelper.commitTransaction();
        return apiTokenEntity.getUserAccountEntity();
    }
}
