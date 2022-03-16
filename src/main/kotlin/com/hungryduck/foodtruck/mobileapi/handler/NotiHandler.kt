package com.hungryduck.foodtruck.mobileapi.handler

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
        val os = serverRequest.queryParam("os").get()
        val osVer = serverRequest.queryParam("os_ver").get()
        val appVer = serverRequest.queryParam("app_ver").get()

        return notiAppTargetService.getNotiAppTarget(os, osVer, appVer)
            .filter(Objects::nonNull)
            .flatMap { ServerResponse.ok().body(BodyInserters.fromValue(it)) }
    }
}