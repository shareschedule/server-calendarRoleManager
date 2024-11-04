package com.schedule.share.rolemanager.application.port.outbound

import com.schedule.share.rolemanager.domain.CalendarRole

interface CalendarRoleQueryPort {
    fun findByUserId(userId: Long): CalendarRole

    fun findByCalendarId(calendarId: Long): CalendarRole
}