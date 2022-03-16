package com.hungryduck.foodtruck.mobileapi.router

import com.hungryduck.foodtruck.mobileapi.handler.NotiHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration
class RouterConfig {
    @Bean
    fun rootRouter(notiHandler: NotiHandler): RouterFunction<ServerResponse> {
        return RouterFunctions.route()
            .GET("/foodtruck/notification", notiHandler::getNoti)
            .build()
    }
}