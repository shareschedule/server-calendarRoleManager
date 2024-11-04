package com.schedule.share.rolemanager.application.service.rolemanager

import com.schedule.share.rolemanager.application.port.outbound.CalendarRoleQueryPort
import org.springframework.stereotype.Service
import com.schedule.share.rolemanager.application.port.inbound.ValidateCalendarUserUseCase as ValidateCalendarUserPort

@Service
class ValidateCalendarUserService(
    private val calendarRoleQueryPort: CalendarRoleQueryPort,
) : ValidateCalendarUserPort {
    override fun validateCalendarOwnership(userId: Long, calendarId: Long): Long {
        val userRoleInfo = calendarRoleQueryPort.findByCalendarId(calendarId)
        if(userRoleInfo.userId == userId)
            return userRoleInfo.role
        else
            return -1;
    }

}