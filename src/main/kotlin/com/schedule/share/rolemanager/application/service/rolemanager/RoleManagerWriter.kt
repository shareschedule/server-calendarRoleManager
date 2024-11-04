package com.schedule.share.rolemanager.application.service.rolemanager

import com.schedule.share.rolemanager.application.port.outbound.CalendarRoleCommandPort
import com.schedule.share.rolemanager.application.service.rolemanager.vo.CalendarRoleVO
import com.schedule.share.rolemanager.domain.mapper.toDomain
import org.springframework.stereotype.Component

@Component
class RoleManagerWriter (
    private val calendarRoleCommandPort: CalendarRoleCommandPort

) {
    fun create(param: CalendarRoleVO.Save) {
        calendarRoleCommandPort.create(param.toDomain())
    }

    fun update(param: CalendarRoleVO.Save) {
        calendarRoleCommandPort.update(param.toDomain())
    }

    fun delete(param: Long) {
        calendarRoleCommandPort.delete(param)
    }
}