package com.musiccatalog.model

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime
import java.util.*

object Playlists : BaseTable("playlists") {
    val name = varchar("name", 255)
    val description = text("description").nullable()
    val coverImageUrl = varchar("cover_image_url", 512).nullable()
    val isPublic = bool("is_public").default(true)
    val userId = reference("user_id", Users.id, onDelete = ReferenceOption.CASCADE)
    val isActive = bool("is_active").default(true)
}

data class Playlist(
    val id: UUID? = null,
    val name: String,
    val description: String? = null,
    val coverImageUrl: String? = null,
    val isPublic: Boolean = true,
    val userId: UUID,
    val isActive: Boolean = true,
    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null,
    val deletedAt: LocalDateTime? = null
)

data class PlaylistWithDetails(
    val playlist: Playlist,
    val user: User,
    val songs: List<SongWithDetails> = emptyList()
)

data class PlaylistCreate(
    val name: String,
    val description: String? = null,
    val isPublic: Boolean = true,
    val songIds: List<UUID> = emptyList()
)

data class PlaylistUpdate(
    val name: String? = null,
    val description: String? = null,
    val coverImageUrl: String? = null,
    val isPublic: Boolean? = null,
    val isActive: Boolean? = null
)
