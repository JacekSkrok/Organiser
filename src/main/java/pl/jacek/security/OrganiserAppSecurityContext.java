package pl.jacek.security;

import pl.jacek.model.UserAccountEntity;

import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import java.security.Principal;

public class OrganiserAppSecurityContext implements SecurityContext {

    private final UserAccountEntity user;
    private final UriInfo uriInfo;


    public OrganiserAppSecurityContext(UserAccountEntity user, UriInfo uriInfo) {
        this.user = user;
        this.uriInfo = uriInfo;
    }

    @Override
    public Principal getUserPrincipal() {
        return new OrganiserAppPrincipal(this.user);
    }

    @Override
    public boolean isUserInRole(String s) {
        return true;
    }

    @Override
    public boolean isSecure() {
        if(this.uriInfo == null) {
            return false;
        }
        return this.uriInfo.getAbsolutePath().toString().startsWith("https");
    }

    @Override
    public String getAuthenticationScheme() {
        return "Organiser-App-Auth-Scheme";
    }

}
