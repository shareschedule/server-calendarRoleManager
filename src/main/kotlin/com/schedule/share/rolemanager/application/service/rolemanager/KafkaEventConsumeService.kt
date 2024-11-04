package com.schedule.share.rolemanager.application.service.rolemanager

import com.schedule.share.rolemanager.application.port.inbound.CalendarWithEventCommand
import com.schedule.share.rolemanager.application.port.outbound.CalendarRoleCommandPort
import com.schedule.share.rolemanager.application.service.rolemanager.vo.CalendarRoleVO
import com.schedule.share.rolemanager.domain.mapper.toDomain
import org.springframework.stereotype.Service

@Service
class KafkaEventConsumeService(
    private val calendarRoleCommandPort: CalendarRoleCommandPort
) : CalendarWithEventCommand {

    override fun consumeCreationCalendarEvent(evnet: CalendarRoleVO.Save) {
        calendarRoleCommandPort.create(evnet.toDomain())
    }
}