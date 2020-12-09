package com.svetikov.kotlinreactivespring

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.http.MediaType

import org.springframework.web.reactive.function.server.RouterFunction

import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router
import java.net.URI


@Configuration
class MyPage {

    @Bean
    fun router() = router{
        accept(MediaType.TEXT_HTML).nest {
            GET("/"){permanentRedirect(URI("index.html")).build()}
        }
        resources ( "/**", ClassPathResource("static/") )
    }




}