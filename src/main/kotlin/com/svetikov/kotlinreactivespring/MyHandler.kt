package com.svetikov.kotlinreactivespring

import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType.APPLICATION_JSON

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
            MyMessage(UUID.randomUUID().toString(), "T1"),
            MyMessage(UUID.randomUUID().toString(), "T2"),
            MyMessage(UUID.randomUUID().toString(), "T3")
    )

    val messagePost = mutableListOf<MyMessage>()
    val monoMessages = Mono.just(messages)

    var messageListData = Flux.just(
            MyMessage(UUID.randomUUID().toString(), "T1"),
            MyMessage(UUID.randomUUID().toString(), "T2"),
            MyMessage(UUID.randomUUID().toString(), "T3")
    )
    val mess = Mono.just(MyMessage(idNum, "T3"))


//    @Bean
//    fun addTest() {
//        messageListData = Flux.concat(messageListData, Flux.just(MyMessage(UUID.randomUUID().toString(), "T5")))
//    }


    fun showOneMessage(serverRequest: ServerRequest) = ServerResponse.ok().body(mess, MyMessage::class.java)

    fun showAllMessage(request: ServerRequest) = ServerResponse.ok().body(messageListData, MyMessage::class.java)

    fun getByIdMessage(request: ServerRequest) = ServerResponse.ok()
            .contentType(APPLICATION_JSON)
            .body(filterMess("id", request, messageListData), MyMessage::class.java)
            .switchIfEmpty(ServerResponse.notFound().build())


    fun filterMess(add: String, req: ServerRequest, mess: Flux<MyMessage>): Mono<MyMessage> {

        val messReturn = mess.filter { m -> m.id == req.pathVariable(add) }.elementAt(0)
        return messReturn
    }




    fun addMessage(request: ServerRequest)
    = request.bodyToMono(MyMessage::class.java)
            .flatMap(::saveAndResponse)
            .onErrorResume { e ->
                Mono.just("Error " + e.message)
                        .flatMap { s -> ServerResponse.ok().syncBody(s) }
            }

    private fun saveAndResponse(messageLocal: MyMessage) = ServerResponse.ok()
            .contentType(APPLICATION_JSON)
            .body(save(messageLocal), MyMessage::class.java)

    private fun save(messageLocal: MyMessage): Mono<MyMessage> {
        messageListData=Flux.concat(messageListData,Flux.just(messageLocal))
        return   Mono.just(messageLocal)
    }
}