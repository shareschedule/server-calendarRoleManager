package com.schedule.share.rolemanager.adaptor.inbound.api

import com.schedule.share.rolemanager.application.port.inbound.ValidateCalendarUserUseCase
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/calendar-user")
class ValidateCalendarUserApi (
    private val validateCalendarUserUseCase: ValidateCalendarUserUseCase,
){
    @GetMapping
    fun validateCalendarOwnership(
        @RequestParam userId:Long,
        @RequestParam calendarId: Long,
    ): Long =
        validateCalendarUserUseCase.validateCalendarOwnership(userId, calendarId)
}