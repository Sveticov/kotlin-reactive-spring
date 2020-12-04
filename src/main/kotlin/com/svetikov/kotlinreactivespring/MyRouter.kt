package com.svetikov.kotlinreactivespring


import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.RouterFunctionDsl
import org.springframework.web.reactive.function.server.router
import java.io.ObjectInputStream


@Configuration
class MyRouter(private val myHandler: MyHandler) {
    @Bean
    fun routerFunction() = router {
        "/api".nest {
            accept(APPLICATION_JSON).nest {
                GET("/f", myHandler::showOnlyMessage)  //myHandler::showOnlyMessage
                GET("/t",myHandler::showAllMessage)
                GET("/id/{id}",myHandler::getOneMess)
            }
        }

    }
}




