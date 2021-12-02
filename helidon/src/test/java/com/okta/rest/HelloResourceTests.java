package com.okta.rest;

import io.helidon.microprofile.tests.junit5.HelidonTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.ws.rs.client.WebTarget;

@HelidonTest
class HelloResourceTests {

    @Inject
    private WebTarget webTarget;

    @Test
    void testHello() {
        int status = webTarget.path("/hello").request().get().getStatus();
        Assertions.assertEquals(401,status,"Expected unauthorized");
    }
}
