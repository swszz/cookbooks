package com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.model

import java.time.LocalDateTime
import java.util.*

/**
 * @author: swszz
 */
data class ProductResult(
    val id: UUID,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)