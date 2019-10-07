package com.herokuapp.zeversion.ontormi.models


import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.herokuapp.zeversion.ontormi.USER_EMAIL_INVALID
import com.herokuapp.zeversion.ontormi.USER_EMAIL_NOT_BLANK
import com.herokuapp.zeversion.ontormi.USER_NAME_NOT_BLANK
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Id
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@Entity
@JsonPropertyOrder("id", "name", "email")
data class User(
        @field:NotBlank(message = USER_NAME_NOT_BLANK)
        @Column(nullable = false)
        val name: String,
        @field:NotBlank(message = USER_EMAIL_NOT_BLANK)
        @field:Email(message = USER_EMAIL_INVALID)
        @Column(nullable = false, unique = true)
        val email: String
) {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long = 0
}