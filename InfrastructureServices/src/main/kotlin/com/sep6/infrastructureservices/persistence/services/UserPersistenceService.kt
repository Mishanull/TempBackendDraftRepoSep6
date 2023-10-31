package com.sep6.infrastructureservices.persistence

import com.sep6.infrastructureservices.persistence.entities.UserEntity
import com.sep6.infrastructureservices.persistence.exceptions.ResourceNotFoundException
import com.sep6.infrastructureservices.persistence.repositories.UserPersistenceRepository
import models.User
import org.springframework.stereotype.Service
import repository_contracts.UserRepository
import java.util.*

@Service
class UserPersistenceService(val jpaUserRepo: UserPersistenceRepository) : UserRepository {
  override fun createUser(user: User): User {
    val response = jpaUserRepo.save(UserEntity(user))
    return response.mapToDomain();
  }

  override fun updateUser(user: User) {
    when(jpaUserRepo.existsById(user.userId)){
      true -> jpaUserRepo.save(UserEntity(user))
      false -> throw ResourceNotFoundException("User with id ${user.userId} not found")
    }
  }

  override fun deleteUser(userId: UUID) {
    when(jpaUserRepo.existsById(userId)){
      true -> jpaUserRepo.deleteById(userId)
      false -> throw ResourceNotFoundException("User with id $userId not found")
    }
  }

  override fun getUserById(userId: UUID): User? {
    return if (jpaUserRepo.existsById(userId)) jpaUserRepo.findById(userId).get().mapToDomain() else throw ResourceNotFoundException("User with id $userId not found")
  }

  override fun addFollower(userId: UUID, followerId: UUID) {
    val user: UserEntity = jpaUserRepo.findById(userId).get()
    val follower: UserEntity = jpaUserRepo.findById(userId).get()
    user.following?.add(follower)
    follower.followers?.add(user)
    jpaUserRepo.save(user)
    jpaUserRepo.save(follower)
  }

  override fun getFollowers(userId: UUID) {
    TODO("Not yet implemented")
  }

  override fun getFollowing(userId: UUID) {
    TODO("Not yet implemented")
  }
}