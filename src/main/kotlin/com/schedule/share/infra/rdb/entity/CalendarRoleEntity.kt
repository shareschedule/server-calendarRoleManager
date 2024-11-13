package com.schedule.share.infra.rdb.entity

import com.schedule.share.common.utils.DateUtil
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime


@Entity
@Table(catalog = "role", name = "calendar_user_role")
@EntityListeners(AuditingEntityListener::class)
class CalendarRoleEntity (
    id: Long? = null,
    userId: Long,
    calendarId: Long,
    isBlack: Boolean = false,
    role: Long,
    createdAt: LocalDateTime? = DateUtil.now(),
    modifiedAt: LocalDateTime? = DateUtil.now(),
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long? = id
        protected set

    open var userId: Long = userId
        protected set

    open var calendarId: Long = calendarId
        protected set

    open var isBlack: Boolean = isBlack
        protected set

    open var role: Long = role
        protected set

    @CreatedDate
    open var createdAt: LocalDateTime? = createdAt
        protected set

    @LastModifiedDate
    open var modifiedAt: LocalDateTime? = modifiedAt
        protected set
}