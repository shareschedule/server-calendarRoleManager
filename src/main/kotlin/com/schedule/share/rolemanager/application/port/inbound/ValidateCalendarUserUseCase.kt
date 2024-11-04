package com.schedule.share.rolemanager.application.port.inbound

interface ValidateCalendarUserUseCase {
    fun validateCalendarOwnership(userId: Long, calendarId: Long): Long
}