package com.hungryduck.foodtruck.mobileapi.model

import org.springframework.web.reactive.function.server.ServerRequest

data class NotiRequest(
    val os: String,
    val osVer: String,
    val appVer: String
) {
    companion object {
        fun from(serverRequest: ServerRequest): NotiRequest {
            val os = serverRequest.queryParam("os").orElseThrow { RuntimeException("os parameter is needed") }
            val osVer = serverRequest.queryParam("osVer").orElseThrow { RuntimeException("os parameter is needed") }
            val appVer = serverRequest.queryParam("appVer").orElseThrow { RuntimeException("os parameter is needed") }

            return NotiRequest(os, osVer, appVer)
        }
    }
}