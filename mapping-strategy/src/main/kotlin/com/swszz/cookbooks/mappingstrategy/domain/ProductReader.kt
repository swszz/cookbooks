package com.swszz.cookbooks.mappingstrategy.domain

import com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.model.ProductData
import java.util.*

/**
 * @author: swszz
 */
interface ProductReader {

    fun findById(id: UUID): ProductData
    fun findAllByIds(ids: Set<UUID>): Collection<ProductData>
}