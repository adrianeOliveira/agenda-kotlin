package com.adriane.start.kotlin.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Contact(
        @Id @GeneratedValue @Column(name="id_contact")
        var contactId: Int,
        var name: String?,
        var phoneNumber: String?,
        var active: Boolean
) {}