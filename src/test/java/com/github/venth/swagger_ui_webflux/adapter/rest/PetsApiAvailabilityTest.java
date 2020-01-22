package com.github.venth.swagger_ui_webflux.adapter.rest;

import java.time.Duration;

import com.github.venth.swagger_ui_webflux.Application;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
class PetsApiAvailabilityTest {

    @Test
    void exposesPetsApi() {
        // when
        final var pets = webClient.get().uri("/pets")
                .exchange()
                .timeout(Duration.ofSeconds(1));

        // then
        StepVerifier.create(pets)
                .assertNext(response -> assertEquals(HttpStatus.NOT_IMPLEMENTED, response.statusCode()))
                .expectComplete()
                .verify(Duration.ofSeconds(1));
    }

    @LocalServerPort
    private int localServerPort;

    private WebClient webClient;

    @BeforeEach
    void setUp() {
        webClient = WebClient.create("http://localhost:" + localServerPort);
    }
}
