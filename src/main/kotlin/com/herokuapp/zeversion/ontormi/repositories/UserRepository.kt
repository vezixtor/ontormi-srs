package com.herokuapp.zeversion.ontormi.repositories

import com.herokuapp.zeversion.ontormi.models.User
import org.springframework.data.repository.Repository


interface UserRepository : Repository<User, Long> {

    fun save(user: User): User

    fun findById(id: Long): User?
}