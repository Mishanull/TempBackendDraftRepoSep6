package models

import org.jetbrains.annotations.NotNull
import java.time.LocalDateTime
import java.util.UUID

data class FavoriteList(
  val listId: UUID = UUID.randomUUID(),
  @NotNull val userId: UUID,
  val name: String,
  val itemIds: List<String> = listOf(),
  val timestamp: LocalDateTime
)