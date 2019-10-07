package com.herokuapp.zeversion.ontormi.repositories

import com.herokuapp.zeversion.ontormi.models.Study
import org.springframework.data.repository.Repository


interface StudyRepository : Repository<Study, Long> {

    fun save(Study: Study): Study

    fun findById(id: Long): Study?
}