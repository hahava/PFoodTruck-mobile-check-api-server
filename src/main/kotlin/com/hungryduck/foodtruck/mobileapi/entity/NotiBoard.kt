package com.hungryduck.foodtruck.mobileapi.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table(value = "Noti_board")
data class NotiBoard(
    @Id
    val id: Long,
    val category: String,
    val title: String,
    val message: String,
    val status: String,
    val location: String
)