package com.musiccatalog.model

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.ReferenceOption
import java.util.*

object SongGenres : Table("song_genres") {
    val songId = reference("song_id", Songs.id, onDelete = ReferenceOption.RESTRICT)
    val genreId = reference("genre_id", Genres.id, onDelete = ReferenceOption.RESTRICT)
    
    override val primaryKey = PrimaryKey(songId, genreId, name = "pk_song_genres")
}

data class SongGenre(
    val songId: UUID,
    val genreId: UUID
)
