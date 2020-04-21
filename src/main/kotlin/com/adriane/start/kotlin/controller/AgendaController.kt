package com.adriane.start.kotlin.controller

import com.adriane.start.kotlin.entities.Contato
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/agenda")
class AgendaController {

    @GetMapping
    fun list(): List<Contato>{
        return listOf(Contato("Adriane", "999999999"))
    }

}