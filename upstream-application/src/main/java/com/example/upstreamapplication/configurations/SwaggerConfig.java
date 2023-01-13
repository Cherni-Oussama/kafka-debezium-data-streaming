package com.elyadata.analytics.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Value("${openapi.version}")
    private String openApiVersion;

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("AlgoBrain Analytics API")
                        .description("Analytics for AlgoBrain Solution")
                        .version(openApiVersion)
                );
    }


}
