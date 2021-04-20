package pl.jacek.security;

import pl.jacek.model.UserAccountEntity;

import java.security.Principal;

public class OrganiserAppPrincipal implements Principal {
    private final UserAccountEntity user;

    public OrganiserAppPrincipal(UserAccountEntity user) {
        this.user = user;
    }

    @Override
    public String getName() {
        if (this.user != null) {
            return this.user.getEmail();
        }
        return "---";
    }
}
