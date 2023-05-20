package com.swszz.cookbooks.mappingstrategy.domain.model

import java.time.LocalDateTime
import java.util.*

/**
 * @author: swszz
 */
data class Product(
    val id: UUID,
    val productDetail: ProductDetail,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)