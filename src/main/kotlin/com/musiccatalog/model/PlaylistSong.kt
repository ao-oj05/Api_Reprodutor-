package com.musiccatalog.model

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime
import java.util.*

object PlaylistSongs : Table("playlist_songs") {
    val playlistId = reference("playlist_id", Playlists.id, onDelete = ReferenceOption.CASCADE)
    val songId = reference("song_id", Songs.id, onDelete = ReferenceOption.CASCADE)
    val position = integer("position").default(0)
    val addedAt = datetime("added_at").default(LocalDateTime.now())
    
    override val primaryKey = PrimaryKey(playlistId, songId, name = "pk_playlist_songs")
}

data class PlaylistSong(
    val playlistId: UUID,
    val songId: UUID,
    val position: Int = 0,
    val addedAt: LocalDateTime? = null
)
