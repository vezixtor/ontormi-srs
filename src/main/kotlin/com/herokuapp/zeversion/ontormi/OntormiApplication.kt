package com.herokuapp.zeversion.ontormi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OntormiApplication

fun main(args: Array<String>) {
	runApplication<OntormiApplication>(*args)
}
