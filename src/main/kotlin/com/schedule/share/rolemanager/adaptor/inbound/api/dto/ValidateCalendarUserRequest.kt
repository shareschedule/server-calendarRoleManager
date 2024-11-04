package com.schedule.share.rolemanager.adaptor.inbound.api.dto

class CalendarUserRequestDTO{
    data class CalendarUser(
        val userId: Long,
        val calendarId: Long,
    )
}
