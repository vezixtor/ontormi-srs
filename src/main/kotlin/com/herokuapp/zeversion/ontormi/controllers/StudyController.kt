package com.herokuapp.zeversion.ontormi.controllers

import com.herokuapp.zeversion.ontormi.models.Study
import com.herokuapp.zeversion.ontormi.services.StudyService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/study")
class StudyController(
        private val studyService: StudyService
) {

    @PostMapping
    fun save(@Valid @RequestBody study: Study) = studyService.save(study)

    @GetMapping("{id}")
    fun findById(@PathVariable id: Long) = studyService.findById(id)
}