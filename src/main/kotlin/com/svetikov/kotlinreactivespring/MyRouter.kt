package com.svetikov.kotlinreactivespring


import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router
import java.net.URI


@Configuration
class MyRouter(private val myHandler: MyHandler) {

    @Bean
  //  @CrossOrigin(origins = ["http://localhost:63342"])
    fun routerFunction() = router {
        "/api".nest {
            accept(APPLICATION_JSON).nest {
                GET("/all", myHandler::showAllMessage)  //myHandler::showOnlyMessage
                GET("/one",myHandler::showOneMessage)
                GET("/id/{id}",myHandler::getByIdMessage)
                POST("/add",myHandler::addMessage)
            }
        }

    }


}




