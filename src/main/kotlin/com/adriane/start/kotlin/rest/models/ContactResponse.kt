package com.adriane.start.kotlin.rest.models

data class ContactResponse(
    val contactId: Int,
    val name: String,
    val phoneNumber: String,
    val active: Boolean,
    val items: List<EmailResponse>
)

data class EmailResponse(
    val emailId: Int,
    val emailAddress: String
)