package com.github.venth.swagger_ui_webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.actuate.autoconfigure.web.ManagementContextConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.reactive.config.EnableWebFlux;

@ComponentScan(
        useDefaultFilters = false,
        includeFilters = @ComponentScan.Filter(classes = Configuration.class, type = FilterType.ANNOTATION),
        excludeFilters = @ComponentScan.Filter(classes = ManagementContextConfiguration.class, type = FilterType.ANNOTATION))
@EnableWebFlux
@SpringBootConfiguration
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
