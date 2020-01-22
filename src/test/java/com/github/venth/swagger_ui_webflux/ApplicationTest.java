package com.github.venth.swagger_ui_webflux;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.actuate.autoconfigure.web.server.LocalManagementPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
class ApplicationTest {

    @Test
    void bootstrapsApplicationContext() {
        // when
        final var healthResponse = webClient.get().uri("/actuator/health")
                .exchange()
                .timeout(Duration.ofSeconds(1));

        // then
        StepVerifier.create(healthResponse)
                .assertNext(response -> assertEquals(HttpStatus.OK, response.statusCode()))
                .expectComplete()
                .verify(Duration.ofSeconds(2));
    }

    @BeforeEach
    void setUp() {
        webClient = WebClient.create("http://localhost:" + localManagementPort);
    }

    @LocalManagementPort
    private int localManagementPort;

    private WebClient webClient;
}