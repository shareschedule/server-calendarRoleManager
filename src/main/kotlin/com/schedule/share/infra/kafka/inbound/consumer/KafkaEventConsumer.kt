package com.schedule.share.infra.kafka.inbound.consumer

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.schedule.share.rolemanager.application.port.inbound.CalendarWithEventCommand
import com.schedule.share.rolemanager.domain.event.CalendarCreationEvent
import com.schedule.share.rolemanager.domain.mapper.toVO
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class KafkaEventConsumer(
    private val calendarWithEventCommand: CalendarWithEventCommand
) {
    val objectMapper = jacksonObjectMapper()
    @KafkaListener(groupId = "calendar-role-manager", topics = ["calendar-create-calendars"])
    fun consume(
        massage: String,
    ): String {
        val calendarCreationEvent = objectMapper.readValue<CalendarCreationEvent>(massage)
        calendarWithEventCommand.consumeCreationCalendarEvent(calendarCreationEvent.toVO())
//        acknowledgment.acknowledge()
        return "{} "
    }
}