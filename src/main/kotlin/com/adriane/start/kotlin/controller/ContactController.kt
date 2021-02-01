package com.adriane.start.kotlin.controller

import com.adriane.start.kotlin.entities.Contact
import com.adriane.start.kotlin.repositories.ContactRepository
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/contacts")
class ContactController (
        private val contactRepository: ContactRepository
) {
    private val objectMapper = ObjectMapper()

    @GetMapping
    fun list(): List<Contact> =
        contactRepository.findByActive(true)

    @GetMapping("/{contactId}")
    fun findContactById (@PathVariable contactId: Int): Contact? {
        return contactRepository.findByIdOrNull(contactId)
    }

}