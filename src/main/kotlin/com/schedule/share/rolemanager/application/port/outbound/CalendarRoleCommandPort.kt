package com.schedule.share.rolemanager.application.port.outbound

import com.schedule.share.rolemanager.domain.CalendarRole

interface CalendarRoleCommandPort {
    fun create(param: CalendarRole):Long

    fun update(param: CalendarRole)

    fun delete(param: Long)
}