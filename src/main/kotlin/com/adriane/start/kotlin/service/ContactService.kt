package com.adriane.start.kotlin.service

import com.adriane.start.kotlin.rest.models.ContactResponse
import com.adriane.start.kotlin.rest.models.ContactResquest

interface ContactService {

    fun listActiveContacts() : List<ContactResponse>

    fun findContactById(contactId: Int) : ContactResponse?

    fun createNewContact(contact: ContactResquest) : ContactResponse
}