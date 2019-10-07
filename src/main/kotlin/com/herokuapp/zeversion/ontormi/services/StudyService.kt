package com.herokuapp.zeversion.ontormi.services

import com.herokuapp.zeversion.ontormi.models.Study
import com.herokuapp.zeversion.ontormi.repositories.StudyRepository
import org.springframework.stereotype.Service

@Service
class StudyService(
        private val studyRepository: StudyRepository
) {

    fun save(study: Study): Study {
        study.applySpacedRepetitionSystem()
        return studyRepository.save(study)
    }

    fun findById(id: Long): Study? {
        return studyRepository.findById(id)
    }
}