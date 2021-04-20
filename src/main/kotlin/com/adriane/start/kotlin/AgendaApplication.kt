package com.adriane.start.kotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories(basePackages = ["com.adriane.start.kotlin.repositories"])
@SpringBootApplication
class AgendaApplication

fun main(args: Array<String>) {
    runApplication<AgendaApplication>(*args)
}
