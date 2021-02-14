package com.adriane.start.kotlin.rest.models

data class ContactResquest(
    val name: String,
    val phoneNumber: String,
    val active: Boolean,
    val items: List<EmailRequest>
)

data class EmailRequest(
    val emailAddress: String,
)
