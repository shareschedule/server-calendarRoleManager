package com.schedule.share.rolemanager.application.service.rolemanager.vo

import java.time.LocalDateTime

class CalendarRoleVO {
    data class CalendarRole (
        var id: Long? = null,
        var userId: Long,
        var calendarId: Long,
        var isBlack: Boolean,
        var role: Long,
        var createdAt: LocalDateTime? = null,
        var modifiedAt: LocalDateTime? = null,
    )

    data class Save (
        var userId: Long,
        var calendarId: Long,
        var isBlack: Boolean,
        var role: Long = 1,
    )
}