package com.herokuapp.zeversion.ontormi.models

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDate
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity
class Review(
        @JsonIgnore
        @ManyToOne(optional = false)
        val study: Study,
        val date: LocalDate
) {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @JsonIgnore
    val id: Long = 0
}