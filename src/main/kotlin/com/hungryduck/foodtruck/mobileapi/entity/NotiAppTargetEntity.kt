package com.hungryduck.foodtruck.mobileapi.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table(value = "noti_app_target")
data class NotiAppTargetEntity(
    @Id
    val id: Long,
    val notiBoardId: Long,
    val appInfoId: Long,
    val useYn: Boolean
)