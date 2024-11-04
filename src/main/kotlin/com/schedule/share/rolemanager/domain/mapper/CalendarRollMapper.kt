package com.schedule.share.rolemanager.domain.mapper

import com.schedule.share.infra.rdb.entity.CalendarRoleEntity
import com.schedule.share.rolemanager.application.service.rolemanager.vo.CalendarRoleVO
import com.schedule.share.rolemanager.domain.CalendarRole
import com.schedule.share.rolemanager.domain.event.CalendarCreationEvent

fun CalendarRoleVO.Save.toDomain (
    id: Long? = null,
): CalendarRole =
    CalendarRole(
        id = id,
        userId = userId,
        calendarId = calendarId,
        isBlack = isBlack,
        role = role
    )

fun CalendarRoleEntity.toDomain(
): CalendarRole = CalendarRole(
    id = id,
    userId = userId,
    calendarId = calendarId,
    isBlack = isBlack,
    role = role,
    createdAt = createdAt,
    modifiedAt = modifiedAt
)

fun CalendarRole.toEntity(
): CalendarRoleEntity = CalendarRoleEntity(
    id = id,
    userId = userId,
    calendarId = calendarId,
    isBlack = isBlack,
    role = role,
)

fun CalendarRole.toVO(
): CalendarRoleVO.CalendarRole = CalendarRoleVO.CalendarRole(
    id = id,
    userId = userId,
    calendarId = calendarId,
    isBlack = isBlack,
    role = role,
    createdAt = createdAt,
    modifiedAt = modifiedAt,
)

fun CalendarCreationEvent.toVO(
): CalendarRoleVO.Save =
    CalendarRoleVO.Save(
        userId = userId,
        calendarId = calendarId,
        isBlack = false,
        role = 1
    )

fun CalendarCreationEvent.toDomain(
): CalendarRole = CalendarRole(
    userId = userId,
    calendarId = calendarId,
    role = role
)