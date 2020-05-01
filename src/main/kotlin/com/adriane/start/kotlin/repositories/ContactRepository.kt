package com.adriane.start.kotlin.repositories

import com.adriane.start.kotlin.entities.Contact
import org.springframework.data.jpa.repository.JpaRepository

interface ContactRepository : JpaRepository<Contact, Long> {

    fun findByActive(active : Boolean) : List<Contact>
}