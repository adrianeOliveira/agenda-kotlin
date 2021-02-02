package com.adriane.start.kotlin.entities

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity(name = "contact")
class Contact(
    @Id @GeneratedValue
    var contactId: Int = 0,
    var name: String = "",
    var phoneNumber: String = "",
    var active: Boolean = false,
    @OneToMany(mappedBy = "contact", cascade = [CascadeType.PERSIST], fetch = FetchType.LAZY)
    var emails: MutableList<Email> = mutableListOf()
)

@Entity(name = "email")
class Email(
    @Id @GeneratedValue
    var emailId: Int = 0,
    var emailAddress: String = "",
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "contact_id")
    var contact: Contact = Contact()
)