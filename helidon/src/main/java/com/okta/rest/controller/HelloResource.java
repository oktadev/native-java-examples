package com.okta.rest.controller;

import io.helidon.security.SecurityContext;
import io.helidon.security.annotations.Authenticated;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;

@Path("/hello")
public class HelloResource {

    @Authenticated
    @GET
    public String hello(@Context SecurityContext context) {
       return "Hello, " + context.userName() + "!";
    }
}
