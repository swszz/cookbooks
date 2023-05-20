package com.swszz.cookbooks.mappingstrategy.adapter.`in`.web.model

import java.time.LocalDateTime
import java.util.*

/**
 * @author: swszz
 */
data class Product(
    val id: UUID,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)