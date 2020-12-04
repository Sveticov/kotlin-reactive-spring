package com.svetikov.kotlinreactivespring

import org.springframework.http.MediaType
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.http.ResponseEntity.ok

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Flux

import reactor.core.publisher.Mono
import java.util.*

@Component
class MyHandler() {
    val idNum: String = UUID.randomUUID().toString()

    val messages = listOf(
            Mess(UUID.randomUUID().toString(), "T1"),
            Mess(UUID.randomUUID().toString(), "T2"),
            Mess(UUID.randomUUID().toString(), "T3")
    )
    val monoMessages = Mono.just(messages)

    val messs = Flux.just(
            Mess(UUID.randomUUID().toString(), "T1"),
            Mess(UUID.randomUUID().toString(), "T2"),
            Mess(UUID.randomUUID().toString(), "T3")
    )
    val mess = Mono.just(Mess(idNum, "T3"))

    fun showAllMessage(serverRequest: ServerRequest)
    = ServerResponse.ok().body(mess, Mess::class.java)

    fun showOnlyMessage(request: ServerRequest)
    = ServerResponse.ok().body(messs, Mess::class.java)

    fun getOneMess(request: ServerRequest)
    = ServerResponse.ok()
            .contentType(APPLICATION_JSON)
            .body(filterMess("id",request,messs),Mess::class.java)
            .switchIfEmpty(ServerResponse.notFound().build())
            

    fun filterMess(add: String, req: ServerRequest, mess: Flux<Mess>): Mono<Mess> {

        val messReturn = mess.filter { m->m.id ==req.pathVariable(add) }.elementAt(0)
        return messReturn
    }
}