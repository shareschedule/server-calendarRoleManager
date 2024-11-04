package com.schedule.share.rolemanager.domain

import com.schedule.share.common.utils.DateUtil
import java.time.LocalDateTime

class CalendarRole (
    val id: Long? = null,
    val userId: Long,
    val calendarId: Long,
    val isBlack: Boolean = false,
    val role: Long,
    val createdAt: LocalDateTime? = DateUtil.now(),
    val modifiedAt: LocalDateTime? = DateUtil.now(),
)