package RepositoryContracts

import models.User
import java.util.*

interface UserRepository {
  fun createUser(user: User)
  fun updateUser(user: User)
  fun deleteUser(userId: UUID)
  fun getUserById(userId: UUID): User?
}