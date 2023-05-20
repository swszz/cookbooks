package com.swszz.cookbooks.mappingstrategy.adapter.`in`.web.model

import java.time.LocalDateTime
import java.util.*

/**
 * @author: swszz
 */
data class ProductDetail(
    val id: UUID,
    val price: Long,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
) {
}