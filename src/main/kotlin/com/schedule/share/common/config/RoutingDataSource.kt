package com.schedule.share.common.config

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource
import org.springframework.transaction.support.TransactionSynchronizationManager

class RoutingDataSource: AbstractRoutingDataSource() {

    companion object {
        private const val MASTER = "master"
        private const val REPLICA = "replica"
    }

    override fun determineCurrentLookupKey(): Any
    = if (
        TransactionSynchronizationManager
            .isCurrentTransactionReadOnly()
    ) REPLICA else MASTER;
}