package com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.model

import com.swszz.cookbooks.mappingstrategy.domain.model.ProductDetail
import java.sql.ResultSet
import java.time.LocalDateTime
import java.util.*

/**
 * @author: swszz
 */
data class ProductData(
    val id: UUID,
    val productDetail: ProductDetail,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)