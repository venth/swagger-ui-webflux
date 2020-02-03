package com.github.venth.swagger_ui_webflux.adapter.rest;

import org.openapiinitiative.openapi_specification.examples.api.PetsApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class RestConfiguration {

    @Bean
    PetsApi petsController() {
        return new PetsController();
    }
}
