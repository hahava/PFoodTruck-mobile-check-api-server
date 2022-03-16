package com.hungryduck.foodtruck.mobileapi.service

import com.hungryduck.foodtruck.mobileapi.entity.NotiBoard
import com.hungryduck.foodtruck.mobileapi.repository.NotiAppTargetRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class NotiAppTargetService(
    private val notiAppTargetRepository: NotiAppTargetRepository
) {
    fun getNotiAppTarget(os: String, osVer: String, appVer: String): Mono<NotiBoard> {
        return notiAppTargetRepository.selectNotiAppTarget(os, osVer, appVer)
    }
}