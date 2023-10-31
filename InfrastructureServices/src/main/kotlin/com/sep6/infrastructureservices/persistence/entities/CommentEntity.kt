package com.sep6.infrastructureservices.persistence.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "comments")
data class CommentEntity(
  @Id
  @Column(name = "comment_id")
  val commentId: UUID = UUID.randomUUID(),

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  val user: UserEntity,

  @ManyToOne
  @JoinColumn(name = "review_id", nullable = false)
  val review: ReviewEntity,

  @Column(name = "text", nullable = false)
  val text: String,

  @Column(name = "timestamp", nullable = false)
  val timestamp: Timestamp,

  @Column(name = "up_votes")
  val upVotes: Int = 0,

  @Column(name = "down_votes")
  val downVotes: Int = 0
)