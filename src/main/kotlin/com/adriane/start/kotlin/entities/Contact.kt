package com.adriane.start.kotlin.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity(name = "contact")
class Contact(
        @Id @GeneratedValue
        var contactId: Int = 0,
        var name: String = "",
        var phoneNumber: String = "",
        var active: Boolean = false,
        @OneToMany(mappedBy = "contactId")
        var emails: MutableList<Email> = mutableListOf()
)

@Entity(name = "email")
class Email(
        @Id @GeneratedValue
        var emailId: Int = 0,
        var emailAddress: String = "",
        var contactId: Int = 0
)