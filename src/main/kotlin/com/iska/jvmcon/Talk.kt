package com.iska.jvmcon

import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Talk(val id: String? = null, val title: String? = null)