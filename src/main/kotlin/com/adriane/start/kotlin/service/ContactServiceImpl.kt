package com.adriane.start.kotlin.service

import com.adriane.start.kotlin.entities.Contact
import com.adriane.start.kotlin.entities.Email
import com.adriane.start.kotlin.repositories.ContactRepository
import com.adriane.start.kotlin.rest.models.EmailResponse
import com.adriane.start.kotlin.rest.models.ContactResponse
import com.adriane.start.kotlin.rest.models.ContactResquest
import org.slf4j.LoggerFactory
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ContactServiceImpl(
    private val contactRepository: ContactRepository
) : ContactService{

    private val log = LoggerFactory.getLogger(ContactServiceImpl::class.java)

    override fun listActiveContacts(): List<ContactResponse> {
        log.info("## Buscando lista de contatos ativos")

        val contactList = contactRepository.findByActive(true)

        return contactList
            .map(this::mapContactEntityToResponse)
            .toList()
    }

    override fun findContactById(contactId: Int): ContactResponse? {
        log.info("## Buscando contato pelo id=$contactId")

        val contact = contactRepository.findByIdOrNull(contactId) ?: return null

        return mapContactEntityToResponse(contact)
    }

    override fun createNewContact(contact: ContactResquest): ContactResponse {
        log.info("## Criando novo contato=$contact")

        val entity = contactRepository.save(
            mapContactRequestToEntity(contact)
        )

        log.info("## Criado novo contato=$entity")
        return mapContactEntityToResponse(entity)
    }

    private fun mapContactEntityToResponse(contact: Contact) =
        ContactResponse(
            contact.contactId, contact.name, contact.phoneNumber, contact.active,

            contact.emails.map { item ->
                EmailResponse(
                    item.emailId, item.emailAddress
                )
            }.toList()

        )

    private fun mapContactRequestToEntity(request: ContactResquest): Contact {
        val entity = Contact(
            0,
            request.name,
            request.phoneNumber,
            request.active,
            mutableListOf()
        )

        entity.emails = request.items.map {
            Email(
                0,
                it.emailAddress,
                entity
            )
        }.toMutableList()

        return entity
    }

}