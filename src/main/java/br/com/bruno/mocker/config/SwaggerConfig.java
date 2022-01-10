package br.com.bruno.mocker.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    private static final String BASE_PACKAGE = "br.com.bruno.controller";

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group(BASE_PACKAGE)
                .pathsToMatch("/claro/**")
                .build();
    }

}
