package com.schedule.share.rolemanager.adaptor.outbound

import com.schedule.share.infra.rdb.repository.CalendarRoleRepository
import com.schedule.share.rolemanager.application.port.outbound.CalendarRoleQueryPort
import com.schedule.share.rolemanager.domain.CalendarRole
import com.schedule.share.rolemanager.domain.mapper.toDomain
import org.apache.hc.client5.http.HttpResponseException
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class CalendarRoleQueryAdaptor (
    private val calendarRoleRepository: CalendarRoleRepository
): CalendarRoleQueryPort{

    @Transactional(readOnly = true)
    override fun findByUserId(userId: Long): CalendarRole {
        return calendarRoleRepository.findByUserId(userId)
            //TODO : Exception Handler 정의하기
            .orElseThrow{throw HttpResponseException(404, "에러")}
            .toDomain()
    }

    @Transactional(readOnly = true)
    override fun findByCalendarId(calendarId: Long): CalendarRole {
        return calendarRoleRepository.findByCalendarId(calendarId)
            //TODO : Exception Handler 정의하기
            .orElseThrow { throw HttpResponseException(404, "에러") }
            .toDomain()
    }

}