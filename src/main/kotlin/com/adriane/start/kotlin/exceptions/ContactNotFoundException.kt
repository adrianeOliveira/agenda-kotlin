package com.adriane.start.kotlin.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.client.HttpStatusCodeException

@ResponseStatus(HttpStatus.NOT_FOUND)
class ContactNotFoundException : HttpStatusCodeException(HttpStatus.NOT_FOUND)