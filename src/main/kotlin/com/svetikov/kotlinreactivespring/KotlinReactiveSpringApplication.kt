package com.svetikov.kotlinreactivespring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Mono
import java.util.*
import javax.print.DocFlavor.STRING.TEXT_HTML

@SpringBootApplication

class KotlinReactiveSpringApplication




fun main(args: Array<String>) {
    runApplication<KotlinReactiveSpringApplication>(*args)
}







@RestController
class TestMess(){
    val id= UUID.randomUUID().toString()
    @GetMapping("/t")
    fun showMEss():Mono<Mess>
    = Mono.just(Mess(id,"Kotlin the Best"))
}