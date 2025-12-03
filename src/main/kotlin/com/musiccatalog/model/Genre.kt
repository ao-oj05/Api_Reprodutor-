package com.musiccatalog.model

import org.jetbrains.exposed.sql.Table

object Genres : BaseTable("genres") {
    val name = varchar("name", 100).uniqueIndex()
    val description = text("description").nullable()
    val isActive = bool("is_active").default(true)
}

data class Genre(
    val id: EntityID? = null,
    val name: String,
    val description: String? = null,
    val isActive: Boolean = true,
    val createdAt: java.time.LocalDateTime? = null,
    val updatedAt: java.time.LocalDateTime? = null,
    val deletedAt: java.time.LocalDateTime? = null
)
