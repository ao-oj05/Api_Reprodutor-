package com.musiccatalog.model

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.javatime.timestamp
import java.time.OffsetDateTime
import java.util.*
import com.musiccatalog.model.Artist

object Albums : BaseTable("albumes") {
    val title = varchar("title", 150)
    val releaseYear = integer("release_year").check { it greaterEq 1900 }.nullable()
    val artistId = reference("artist_id", Artists.id, onDelete = ReferenceOption.CASCADE)
    

}

data class Album(
    val id: UUID? = null,
    val title: String,
    val releaseYear: Int? = null,
    val artistId: UUID,
    val createdAt: OffsetDateTime? = null,
    val updatedAt: OffsetDateTime? = null
)

data class AlbumCreate(
    val title: String,
    val releaseYear: Int? = null,
    val artistId: UUID
)

data class AlbumUpdate(
    val title: String? = null,
    val releaseYear: Int? = null
)

data class AlbumWithArtist(
    val album: Album,
    val artist: Artist
)
