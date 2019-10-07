package com.herokuapp.zeversion.ontormi.controllers

import com.herokuapp.zeversion.ontormi.models.User
import com.herokuapp.zeversion.ontormi.services.UserService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/user")
class UserController(
        private val userService: UserService
) {

    @PostMapping
    fun save(@Valid @RequestBody user: User) = userService.save(user)

    @GetMapping("{id}")
    fun findById(@PathVariable id: Long) = userService.findById(id)
}