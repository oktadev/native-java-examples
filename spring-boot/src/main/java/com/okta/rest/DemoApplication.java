package com.okta.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.nativex.hint.AccessBits;
import org.springframework.nativex.hint.NativeHint;
import org.springframework.nativex.hint.ResourceHint;
import org.springframework.nativex.hint.TypeHint;

@SpringBootApplication
/*@NativeHint(options = "--enable-url-protocols=https")
@ResourceHint(patterns = "com/okta/commons/configcheck/configuration-validator", isBundle = true)
@TypeHint(typeNames = {
    "com.okta.spring.boot.oauth.OktaOpaqueTokenIntrospectConditional",
    "com.okta.spring.boot.oauth.OktaOpaqueTokenIntrospectConditional$ClientIdCondition",
    "com.okta.spring.boot.oauth.OktaOpaqueTokenIntrospectConditional$ClientSecretCondition",
    "com.okta.spring.boot.oauth.OktaOpaqueTokenIntrospectConditional$IntrospectionUriCondition"
}, access = AccessBits.ALL)*/
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
