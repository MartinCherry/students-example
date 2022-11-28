package com.example.studentexample.configuration;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder().group("students-example").pathsToMatch("/students/**").build();
    }

    @Bean
    public OpenAPI studentsAPI() {
        return new OpenAPI().info(new Info().title("Student API")
                .description("Student registry API")
                .version("v0.0.1"));
    }


}
