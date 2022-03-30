package com.hungryduck.foodtruck.mobileapi.repository

import com.hungryduck.foodtruck.mobileapi.entity.NotiBoard
import com.hungryduck.foodtruck.mobileapi.model.NotiRequest
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
class NotiAppTargetRepository(
    private val databaseClient: DatabaseClient
) {
    fun selectNotiAppTarget(notiRequest: NotiRequest): Mono<NotiBoard> = databaseClient.sql(
        """
            SELECT noti_board.id,
                   noti_board.category,
                   noti_board.title,
                   noti_board.message,
                   noti_board.status,
                   noti_board.location
            FROM   noti_app_target
                   LEFT JOIN app_info
                          ON app_info.id = noti_app_target.app_info_id
                   LEFT JOIN noti_board
                          ON noti_board.id = noti_app_target.noti_board_id
            WHERE  app_info.os_ver = :osVer
                   AND app_info.os_type = :os
                   AND app_info.app_ver = :appVer
                   AND use_yn = true
        """.trimIndent()
    )
        .bind("os", notiRequest.os)
        .bind("osVer", notiRequest.osVer)
        .bind("appVer", notiRequest.appVer)
        .map { row ->
            NotiBoard(
                id = row.get("id") as Long,
                category = row.get("category") as String,
                title = row.get("title") as String,
                message = row.get("message") as String,
                status = row.get("status") as String,
                location = row.get("location") as String,
            )
        }.one()
}
