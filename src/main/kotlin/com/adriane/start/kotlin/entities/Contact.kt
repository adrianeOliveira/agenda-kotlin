package com.adriane.start.kotlin.entities

import javax.persistence.CascadeType
import javax.persistence.Column
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
    val contactId: Int,
    val name: String,
    val phoneNumber: String,
    val active: Boolean,
    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "contact")
    var emails: MutableList<Email>
)

@Entity(name = "email")
class Email(
    @Id
    @SequenceGenerator(name = "emailIdSEQ", sequenceName = "email_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "emailIdSEQ")
    val emailId: Int,
    val emailAddress: String,
    @ManyToOne  @JoinColumn(name = "contact_id")
    val contact: Contact ?
)