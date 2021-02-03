package com.adriane.start.kotlin.entities

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.SequenceGenerator

@Entity(name = "contact")
class Contact(
    @Id
    @SequenceGenerator(name = "contactIdSEQ", sequenceName = "contact_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "contactIdSEQ")
    var contactId: Int = 0,
    var name: String = "",
    var phoneNumber: String = "",
    var active: Boolean = false,
    @OneToMany(mappedBy = "contact", cascade = [CascadeType.ALL])
    var emails: MutableList<Email> = mutableListOf()
)

@Entity(name = "email")
class Email(
    @Id
    @SequenceGenerator(name = "emailIdSEQ", sequenceName = "email_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "emailIdSEQ")
    var emailId: Int = 0,
    var emailAddress: String = "",
    @ManyToOne(targetEntity = Contact::class) @JoinColumn(name = "contact_id")
    var contact: Int = 0
)