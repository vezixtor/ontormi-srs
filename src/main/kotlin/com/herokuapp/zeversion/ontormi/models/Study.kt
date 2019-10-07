package com.herokuapp.zeversion.ontormi.models

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.herokuapp.zeversion.ontormi.STUDY_DESCRIPTION_BLANK
import com.herokuapp.zeversion.ontormi.STUDY_SUBJECT_NOT_BLANK
import java.time.LocalDate
import java.util.stream.Collectors
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY
import javax.validation.Valid
import javax.validation.constraints.NotBlank

@Entity
@JsonPropertyOrder("id", "subject", "description", "reviews")
class Study(
        @field:NotBlank(message = STUDY_SUBJECT_NOT_BLANK)
        val subject: String,
        @field:NotBlank(message = STUDY_DESCRIPTION_BLANK)
        val description: String
) {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long = 0

    @JsonIgnore
    @field:Valid
    @ManyToOne(optional = true)
    val user: User? = null

    @OneToMany(mappedBy = "study", cascade = [CascadeType.ALL])
    val reviews: MutableList<Review?> = mutableListOf()

    fun applySpacedRepetitionSystem() {
        val now = LocalDate.now()
        val daysOfReview = listOf(1L, 3L, 10L, 30L, 90L)
        reviews.addAll(daysOfReview.stream()
                .map { Review(this, now.plusDays(it)) }
                .collect(Collectors.toList()))
    }
}