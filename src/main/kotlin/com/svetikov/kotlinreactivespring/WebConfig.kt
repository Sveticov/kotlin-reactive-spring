package com.svetikov.kotlinreactivespring

import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.CorsRegistry
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.WebFluxConfigurer
@Configuration
@EnableWebFlux
class WebConfig:WebFluxConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:63342/kotlin-reactive-spring/kotlin-reactive-spring.main/index.html?_ijt=f51p0bhfasglgd1tnmnikcclh9")
                .allowedMethods("GET,POST")
                .allowedHeaders("Access-Control-Allow-Origin")
    }

}