package pl.jacek.main;

import org.glassfish.jersey.server.ResourceConfig;
import pl.jacek.security.annotation.AuthenticateFilter;

public class ServerConfig extends ResourceConfig {
    public ServerConfig() {
        register(AuthenticateFilter.class);
    }
}
