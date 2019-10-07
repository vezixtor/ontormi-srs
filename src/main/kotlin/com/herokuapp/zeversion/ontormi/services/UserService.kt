package com.herokuapp.zeversion.ontormi.services

import com.herokuapp.zeversion.ontormi.models.User
import com.herokuapp.zeversion.ontormi.repositories.UserRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping

@Service
class UserService(
        private val userRepository: UserRepository
) {

    fun save(user: User): User {
        return userRepository.save(user)
    }

    fun findById(id: Long): User? = userRepository.findById(id)
}