package com.schedule.share.rolemanager.application.service

interface DomainQuery<T> {

    fun get(userId: Long, id: Long): T

    fun list(userId: Long): List<T>
}
