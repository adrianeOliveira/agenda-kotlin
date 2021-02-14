package com.adriane.start.kotlin.rest.controller

import com.adriane.start.kotlin.exceptions.ContactNotFoundException
import com.adriane.start.kotlin.rest.models.ContactResponse
import com.adriane.start.kotlin.rest.models.ContactResquest
import com.adriane.start.kotlin.service.ContactService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/contacts")
class ContactController (
        private val contactService: ContactService
) {
    @GetMapping
    fun list() = contactService.listActiveContacts()

    @GetMapping("/{contactId}")
    fun findContactById (@PathVariable contactId: Int): ContactResponse {
        return contactService.findContactById(contactId) ?:
            throw ContactNotFoundException()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createNewContact(@RequestBody contact: ContactResquest) : ContactResponse {
        return contactService.createNewContact(contact)
    }

}