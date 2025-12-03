package com.musiccatalog.model

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.timestamp
import java.time.OffsetDateTime
import java.util.*

typealias EntityID = UUID

interface BaseEntity {
    val id: UUID?
    val createdAt: OffsetDateTime?
    val updatedAt: OffsetDateTime?
}

abstract class BaseTable(name: String) : Table(name) {
    val id = uuid("id").primaryKey().default(UUID.randomUUID())
    val createdAt = timestamp("created_at").clientDefault { OffsetDateTime.now() }
    val updatedAt = timestamp("updated_at").clientDefault { OffsetDateTime.now() }
}
