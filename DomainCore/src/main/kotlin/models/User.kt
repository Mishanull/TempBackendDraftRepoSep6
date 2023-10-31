package Models

import java.time.LocalDate
import java.util.UUID

data class User(
    val username: String,
    val email: String,
    val birthday: LocalDate,
    val userId: UUID = UUID.randomUUID(), // Generate a UUID for the user during object creation
    val role: UserRole
) {
    // Additional properties or methods can be added here
}

enum class UserRole {
    ADMIN,
    STANDARD_USER,
    MODERATOR
}


