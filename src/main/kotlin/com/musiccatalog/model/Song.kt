package com.musiccatalog.model

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.javatime.timestamp
import java.time.OffsetDateTime
import java.util.*
import com.musiccatalog.model.Album
import com.musiccatalog.model.Artist

object Tracks : BaseTable("tracks") {
    val title = varchar("title", 150)
    val duration = integer("duration").check { it greaterEq 1 }
    val albumId = reference("album_id", Albums.id, onDelete = ReferenceOption.CASCADE)
    

}

data class Track(
    val id: UUID? = null,
    val title: String,
    val duration: Int,
    val albumId: UUID,
    val createdAt: OffsetDateTime? = null,
    val updatedAt: OffsetDateTime? = null
)

data class TrackCreate(
    val title: String,
    val duration: Int,
    val albumId: UUID
)

data class TrackUpdate(
    val title: String? = null,
    val duration: Int? = null
)

data class TrackWithDetails(
    val track: Track,
    val album: Album,
    val artist: Artist
)
