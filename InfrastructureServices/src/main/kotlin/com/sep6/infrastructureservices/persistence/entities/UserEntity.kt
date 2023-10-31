package com.sep6.infrastructureservices.persistence.entities

import jakarta.persistence.*
import java.time.LocalDate
import java.util.*

@Entity
@Table(name = "users")
data class User(
  @Id
  @Column(name = "user_id")
  val userId: UUID? = null,

  @Column(name = "username", nullable = false)
  val username: String,

  @Column(name = "email", nullable = false)
  val email: String,

  @Column(name = "birthday", nullable = false)
  val birthday: LocalDate,

  @Enumerated(EnumType.STRING)
  @Column(name = "role", nullable = false)
  val role: String
) {
  constructor(user: com.example.domain.core.User) : this(
    user.userId,
    user.username,
    user.email,
    user.birthday,
    user.role.name
  )
}