package com.hungryduck.foodtruck.mobileapi.service

import com.hungryduck.foodtruck.mobileapi.entity.NotiBoard
import com.hungryduck.foodtruck.mobileapi.model.NotiRequest
import com.hungryduck.foodtruck.mobileapi.repository.NotiAppTargetRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class NotiAppTargetService(
    private val notiAppTargetRepository: NotiAppTargetRepository
) {
    fun getNotiAppTarget(notiRequest: NotiRequest): Mono<NotiBoard> {
        return notiAppTargetRepository.selectNotiAppTarget(notiRequest)
    }
}