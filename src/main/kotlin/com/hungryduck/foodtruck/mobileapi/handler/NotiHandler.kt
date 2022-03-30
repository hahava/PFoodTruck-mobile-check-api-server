package com.hungryduck.foodtruck.mobileapi.handler

import com.hungryduck.foodtruck.mobileapi.model.NotiRequest
import com.hungryduck.foodtruck.mobileapi.service.NotiAppTargetService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import java.util.*

@Component
class NotiHandler(
    private val notiAppTargetService: NotiAppTargetService
) {
    fun getNoti(serverRequest: ServerRequest): Mono<ServerResponse> {
        val notiRequest = try {
            NotiRequest.from(serverRequest)
        } catch (e: Exception) {
            return Mono.error(e)
        }

        return notiAppTargetService.getNotiAppTarget(notiRequest)
            .filter(Objects::nonNull)
            .flatMap { ServerResponse.ok().body(BodyInserters.fromValue(it)) }
            .switchIfEmpty(ServerResponse.notFound().build())
    }
}