package com.adriane.start.kotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AgendaApplication

fun main(args: Array<String>) {
    runApplication<AgendaApplication>(*args)
}
