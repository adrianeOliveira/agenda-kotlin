package com.adriane.start.kotlin.entities

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
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
    @OneToMany(cascade = [CascadeType.ALL]) @JoinColumn(name = "contact_id")
    var emails: MutableList<Email> = mutableListOf()
)

@Entity(name = "email")
class Email(
    @Id
    @SequenceGenerator(name = "emailIdSEQ", sequenceName = "email_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "emailIdSEQ")
    var emailId: Int = 0,
    var emailAddress: String = "",
    @Column(name = "contact_id")
    var contact: Int = 0
)