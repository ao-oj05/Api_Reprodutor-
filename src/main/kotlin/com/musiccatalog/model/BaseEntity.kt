package com.musiccatalog.model

import org.jetbrains.exposed.sql.Table
import java.time.OffsetDateTime
import java.util.*

typealias EntityID = UUID

// Interfaz base para entidades con campos comunes
interface BaseEntity {
    val id: UUID?
    val createdAt: OffsetDateTime?
    val updatedAt: OffsetDateTime?
}

// Clase base abstracta para entidades
abstract class BaseTable(name: String) : Table(name) {
    val id = uuid("id").primaryKey().default(UUID.randomUUID())
    val createdAt = timestamp("created_at").default(OffsetDateTime.now())
    val updatedAt = timestamp("updated_at").default(OffsetDateTime.now())
}
