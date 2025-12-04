package com.musiccatalog.model

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.timestamp
import java.time.Instant
import java.util.*

typealias EntityID = UUID

interface BaseEntity {
    val id: UUID?
    val createdAt: Instant?
    val updatedAt: Instant?
}

abstract class BaseTable(name: String) : Table(name) {
    val id = uuid("id").clientDefault { UUID.randomUUID() }
    val createdAt = timestamp("created_at").clientDefault { Instant.now() }
    val updatedAt = timestamp("updated_at").clientDefault { Instant.now() }
    
    override val primaryKey = PrimaryKey(id, name = "pk_${tableName}_id")
}
