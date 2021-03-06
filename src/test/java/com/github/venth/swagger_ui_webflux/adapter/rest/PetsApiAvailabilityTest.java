package com.github.venth.swagger_ui_webflux.adapter.rest;

import com.github.venth.swagger_ui_webflux.Application;
import com.github.venth.swagger_ui_webflux.test.BlockHoundExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;

@AutoConfigureWebTestClient
@ExtendWith(BlockHoundExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
class PetsApiAvailabilityTest {

    @Test
    void exposesPetsApi() {
        // when
        final var pets = webClient.get().uri("/pets")
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.NOT_IMPLEMENTED);
    }

    @Autowired
    private WebTestClient webClient;
}
