package com.swszz.cookbooks.mappingstrategy.domain.model

import java.time.LocalDateTime
import java.util.*

/**
 * @author: swszz
 */
data class ProductData(
    val id: UUID,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)