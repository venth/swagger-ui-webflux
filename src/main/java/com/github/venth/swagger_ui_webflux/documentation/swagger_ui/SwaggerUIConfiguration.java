package com.github.venth.swagger_ui_webflux.documentation.swagger_ui;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.resource.WebJarsResourceResolver;
import org.webjars.WebJarAssetLocator;

@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class SwaggerUIConfiguration implements WebFluxConfigurer {

    private final Environment environment;

    @Bean
    WebJarAssetLocator webJarAssetLocator() {
        return new WebJarAssetLocator();
    }

    @Bean
    WebJarsResourceResolver webJarsResourceResolver() {
        return new WebJarsResourceResolver(webJarAssetLocator());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        final var cachedIfNotLocalEnvironment = !ArrayUtils.contains(environment.getActiveProfiles(), "local");
        registry
                .addResourceHandler("/documentations/**")
                .addResourceLocations(
                        "classpath:/documentations/",
                        "classpath:/META-INF/resources/webjars/",
                        "classpath:/specs/")
                .resourceChain(cachedIfNotLocalEnvironment)
                .addResolver(webJarsResourceResolver());
    }

}
