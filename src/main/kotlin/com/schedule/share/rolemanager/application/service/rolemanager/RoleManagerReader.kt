package com.schedule.share.rolemanager.application.service.rolemanager

import com.schedule.share.rolemanager.application.port.outbound.CalendarRoleQueryPort
import com.schedule.share.rolemanager.application.service.rolemanager.vo.CalendarRoleVO
import com.schedule.share.rolemanager.domain.mapper.toVO
import org.springframework.stereotype.Component

@Component
class RoleManagerReader (
    private val calendarRoleQueryPort: CalendarRoleQueryPort
) {
    fun getByUserId(
        userId: Long
    ): CalendarRoleVO.CalendarRole = calendarRoleQueryPort.findByUserId(userId).toVO()

    fun getByCalendarId(
        calendarId: Long
    ): CalendarRoleVO.CalendarRole = calendarRoleQueryPort.findByCalendarId(calendarId).toVO()
}