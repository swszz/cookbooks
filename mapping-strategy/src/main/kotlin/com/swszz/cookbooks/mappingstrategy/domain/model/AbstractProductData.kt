package com.swszz.cookbooks.mappingstrategy.domain.model

import java.time.LocalDateTime
import java.util.*

/**
 * @author: swszz
 */
abstract class AbstractProductData(
    private val id: UUID,
    private val createdAt: LocalDateTime,
    private val updatedAt: LocalDateTime,
)