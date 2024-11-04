package com.schedule.share.rolemanager.domain.event

data class CalendarCreationEvent(
    val calendarId: Long,
    val userId: Long,
    val role: Long = 1,
)