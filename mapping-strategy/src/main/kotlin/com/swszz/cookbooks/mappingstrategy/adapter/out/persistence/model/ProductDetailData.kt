package com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.model

import java.time.LocalDateTime
import java.util.*

/**
 * @author: swszz
 */
data class ProductDetailData(
    val id: UUID,
    val price: Long,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)