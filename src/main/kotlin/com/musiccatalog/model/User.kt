package com.musiccatalog.model

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.javatime.datetime
import org.jetbrains.exposed.sql.javatime.timestamp
import java.time.LocalDateTime
import java.util.*

object Users : BaseTable("users") {
    val username = varchar("username", 50).uniqueIndex()
    val email = varchar("email", 255).uniqueIndex()
    val passwordHash = varchar("password_hash", 255)
    val fullName = varchar("full_name", 100).nullable()
    val bio = text("bio").nullable()
    val profileImageUrl = varchar("profile_image_url", 512).nullable()
    val isActive = bool("is_active").default(true)
    val lastLoginAt = datetime("last_login_at").nullable()
}

data class User(
    val id: UUID? = null,
    val username: String,
    val email: String,
    val passwordHash: String,
    val fullName: String? = null,
    val bio: String? = null,
    val profileImageUrl: String? = null,
    val isActive: Boolean = true,
    val lastLoginAt: LocalDateTime? = null,
    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null,
    val deletedAt: LocalDateTime? = null
)

data class UserCreate(
    val username: String,
    val email: String,
    val password: String,
    val fullName: String? = null
)

data class UserUpdate(
    val fullName: String? = null,
    val bio: String? = null,
    val profileImageUrl: String? = null
)
