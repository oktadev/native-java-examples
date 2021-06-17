package com.okta.rest.quarkus;

import io.quarkus.oidc.IdToken;
import io.quarkus.security.Authenticated;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {

    @Inject
    @IdToken
    JsonWebToken idToken;

    @GET
    @Path("/")
    @Authenticated
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello, " + this.idToken.getName() + "!";
    }
}
