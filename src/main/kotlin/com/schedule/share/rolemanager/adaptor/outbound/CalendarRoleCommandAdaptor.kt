package com.schedule.share.rolemanager.adaptor.outbound

import com.schedule.share.infra.rdb.repository.CalendarRoleRepository
import com.schedule.share.rolemanager.application.port.outbound.CalendarRoleCommandPort
import com.schedule.share.rolemanager.domain.CalendarRole
import com.schedule.share.rolemanager.domain.mapper.toEntity
import org.springframework.stereotype.Component

@Component
class CalendarRoleCommandAdaptor (
    private val calendarRoleRepository: CalendarRoleRepository,
): CalendarRoleCommandPort{
    override fun create(param: CalendarRole): Long{
        return calendarRoleRepository.save(param.toEntity()).id!!
    }

    override fun update(param: CalendarRole) {
        calendarRoleRepository.save(param.toEntity())
    }

    override fun delete(id: Long) {
        calendarRoleRepository.deleteById(id)
    }
}