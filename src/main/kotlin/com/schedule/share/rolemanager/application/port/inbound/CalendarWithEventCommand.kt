package com.schedule.share.rolemanager.application.port.inbound

import com.schedule.share.rolemanager.application.service.rolemanager.vo.CalendarRoleVO

interface CalendarWithEventCommand {
    fun consumeCreationCalendarEvent(evnet : CalendarRoleVO.Save)
}