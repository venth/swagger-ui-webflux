package com.github.venth.swagger_ui_webflux.documentations.swagger_ui;

import com.github.venth.swagger_ui_webflux.Application;
import com.github.venth.swagger_ui_webflux.test.BlockHoundExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@AutoConfigureWebTestClient
@ExtendWith(BlockHoundExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
class SwaggerUITest {

    @Test
    void exposesSwaggerUI() {
        // when
        webClient.get().uri("/documentations/swagger-ui/index.html")
                .exchange()
                .expectStatus().isOk();
    }

    @Autowired
    private WebTestClient webClient;
}
