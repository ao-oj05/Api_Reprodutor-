package com.musiccatalog.model

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.javatime.timestamp
import java.time.OffsetDateTime
import java.util.*

object Artists : BaseTable("artistas") {
    val name = varchar("name", 100).uniqueIndex()
    val genre = varchar("genre", 50).nullable()
    

}

data class Artist(
    val id: UUID? = null,
    val name: String,
    val genre: String? = null,
    val createdAt: OffsetDateTime? = null,
    val updatedAt: OffsetDateTime? = null
)

data class ArtistCreate(
    val name: String,
    val genre: String? = null
)

data class ArtistUpdate(
    val name: String? = null,
    val genre: String? = null
)
