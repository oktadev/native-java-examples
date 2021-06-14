package com.okta.rest.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import java.security.Principal;

@Controller("/hello")
public class HelloController {

    @Get
    @Secured(SecurityRule.IS_AUTHENTICATED)
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(Principal principal) {
        return "Hello, " + principal.getName() + "!";
    }

}
