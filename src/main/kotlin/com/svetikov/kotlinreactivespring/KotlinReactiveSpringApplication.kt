package com.svetikov.kotlinreactivespring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.util.*

@SpringBootApplication

class KotlinReactiveSpringApplication




fun main(args: Array<String>) {
    runApplication<KotlinReactiveSpringApplication>(*args)
}







@RestController
class TestMess(){
    val id= UUID.randomUUID().toString()
    @GetMapping("/t")
    fun showMEss():Mono<MyMessage>
    = Mono.just(MyMessage(id,"Kotlin the Best"))
}