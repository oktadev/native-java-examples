package com.okta.rest.quarkus;

import io.quarkus.security.Authenticated;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

@Path("/hello")
public class HelloResource {

    @GET
    @Path("/")
    @Authenticated
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@Context SecurityContext context) {
        Principal userPrincipal = context.getUserPrincipal();
        return "Hello, " + userPrincipal.getName() + "!";
    }

}
