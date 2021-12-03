# Native Java Examples: Micronaut, Quarkus, and Spring Boot

This repository contains example OAuth 2.0 resource servers built with Micronaut, Quarkus, and Spring Boot. If you'd like to see how they were built, please read, [Build Native Java Apps with Micronaut, Quarkus, and Spring Boot][blog].

It also contains a Helidon example. You can read about how it was built, and how it compares in [Build REST APIs and Native Java Apps with Helidon][blog-helidon].

**Prerequisites:** [Java 17 with GraalVM](https://sdkman.io/), [HTTPie](https://httpie.io/), and [Docker](https://docs.docker.com/engine/install/) (optional).

* [Getting Started](#getting-started)
* [Links](#links)
* [Help](#help)
* [License](#license)

## Getting Started

First, clone this repository:

```bash
git clone https://github.com/oktadev/native-java-examples.git
```

You will need a JDK with GraalVM and its native-image compiler. Using [SDKMAN](https://sdkman.io), run the following command and set it as the default:

```bash
sdk install java 21.3.0.r17-grl
```

Add the native extension to the JDK:

```bash
gu install native-image
```

Next, you'll need a free Okta developer account. Install the [Okta CLI](https://cli.okta.com/) and run `okta register` to sign up for a new account. If you already have an account, run `okta login`. Then, run `okta apps create`. Select the default app name, or change it as you see fit. Choose **Single-Page App** and press **Enter**.

Use `https://oidcdebugger.com/debug` for the Redirect URI and set the Logout Redirect URI to `https://oidcdebugger.com`.

Take note of the `clientId` and `issuer` values. You'll need those to get an access token and to configure each framework for JWT authentication.

Change the following files for each framework to match your Okta domain:

- Micronaut: `micronaut/src/main/resources/application.yml`
- Quarkus: `quarkus/src/main/resources/application.properties`
- Spring Boot: `spring-boot/src/main/resources/application.properties`
- Helidon: `helidon/src/main/resources/META-INF/microprofile-config.properties`

You can start each app using Maven. Note that you will only be able to start one at a time since they all run on port 8080.

- Micronaut: `./mvnw mn:run`
- Quarkus: `./mvnw quarkus:dev`
- Spring Boot: `./mvnw spring-boot:run`
- Helidon: `mvn package && java -jar target/helidon.jar`

Then, you can test them with an access token and HTTPie.

You can generate an acces token using [OpenID Connect Debugger](https://oidcdebugger.com/). First, you must configure your application on Okta to use OpenID Connect's implicit flow.

Run `okta login` and open the resulting URL in your browser. Go to the **Applications** section and select the application you created with the CLI. Edit its General Settings and add **Implicit (Hybrid)** as an allowed grant type, with access token enabled. Click **Save** and copy the client ID for the next step.

Now, navigate to the [OpenID Connect Debugger website](https://oidcdebugger.com/). Fill in your client ID, and use `https://{yourOktaDomain}/oauth2/default/v1/authorize` for the Authorize URI. The state field must be filled but can contain any characters. Select **token** for the response type. Click **Send Request** to continue.

Once you have an access token, set it as a `TOKEN` environment variable in a terminal window.

```bash
TOKEN=eyJraWQiOiJYa2pXdjMzTDRBYU1ZSzNGM...
```

Use HTTPie to pass the JWT in as a bearer token in the `Authorization` header.

```bash
http :8080/hello Authorization:"Bearer $TOKEN"
```

You should see your email address printed to your terminal.

You can also build and run each example as a native app.

- Micronaut: `./mvnw package -Dpackaging=native-image`
- Quarkus: `./mvnw package -Pnative`
- Spring Boot: `./mvnw spring-boot:build-image` (or `./mvnw package -Pnative` if you don't have Docker installed)
- Helidon: `mvn package -Pnative-image`

Then, start each app as a native executable.

- Micronaut: `./target/app`
- Quarkus: `./target/quarkus-1.0.0-SNAPSHOT-runner`
- Spring Boot: `docker run -p 8080:8080 demo:0.0.1-SNAPSHOT` (or `./target/demo` if you didn't use Docker)
- Helidon: `./target/helidon`

Please read [Build Native Java Apps with Micronaut, Quarkus, and Spring Boot][blog] for performance numbers and analysis.

## Links

This example uses the following open source libraries:

* [Micronaut](https://micronaut.io)
* [Quarkus](https://quarkus.io)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Helidon](https://helidon.io)

## Help

Please post any questions as comments on [this example's blog post][blog], or on the [Okta Developer Forums](https://devforum.okta.com/).

## License

Apache 2.0, see [LICENSE](LICENSE).

[blog]: https://developer.okta.com/blog/2021/06/18/native-java-framework-comparison
[blog-helidon]: https://developer.okta.com/blog/TBD
