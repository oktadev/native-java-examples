package com.okta.rest;

import com.okta.rest.controller.HelloResource;
import org.eclipse.microprofile.auth.LoginConfig;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Application;
import java.util.Set;

@LoginConfig(authMethod = "MP-JWT")
@ApplicationScoped
public class HelloApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        return Set.of(HelloResource.class);
    }
}
