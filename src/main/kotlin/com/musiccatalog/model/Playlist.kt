package com.musiccatalog.model

import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.timestamp
import java.time.OffsetDateTime
import java.util.*

object Playlists : Table("playlists") {
    val id = uuid("id").equals().default(UUID.randomUUID())
    val title = varchar("title", 150)
    val description = text("description").nullable()
    val userId = reference("user_id", Users.id, onDelete = ReferenceOption.CASCADE)
    val isPublic = bool("is_public").default(false)
    val createdAt = timestamp("created_at").clientDefault { OffsetDateTime.now() }
    val updatedAt = timestamp("updated_at").clientDefault { OffsetDateTime.now() }
}

data class Playlist(
    override val id: UUID? = null,
    val title: String,
    val description: String? = null,
    val userId: UUID,
    val isPublic: Boolean = false,
    override val createdAt: OffsetDateTime? = null,
    override val updatedAt: OffsetDateTime? = null
) : BaseEntity
