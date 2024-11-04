package com.schedule.share.infra.rdb.repository

import com.schedule.share.infra.rdb.entity.CalendarRoleEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CalendarRoleRepository : JpaRepository<CalendarRoleEntity, Long> {
    fun findByUserId(userId: Long): Optional<CalendarRoleEntity>
    fun findByCalendarId(calendarId: Long): Optional<CalendarRoleEntity>
}