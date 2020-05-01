package com.adriane.start.kotlin.controller

import com.adriane.start.kotlin.entities.Contact
import com.adriane.start.kotlin.repositories.ContactRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/agenda")
class AgendaController (
        val contactRepository: ContactRepository
) {
    @GetMapping
    fun list(): List<Contact> = contactRepository.findByActive(true)
}