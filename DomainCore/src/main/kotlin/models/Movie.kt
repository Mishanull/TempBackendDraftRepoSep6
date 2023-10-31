package models

import org.jetbrains.annotations.NotNull
import java.time.Duration
import java.time.LocalDate
import java.util.*

data class Movie (
  @NotNull val movieId: UUID = UUID.randomUUID(),
  @NotNull override val externalId: String,
  val title: String,
  val genre: String,
  val releaseDate: LocalDate,
  val duration: Duration
) : Item(movieId, externalId)