package com.swszz.cookbooks.mappingstrategy.adapter.out.persistence

import com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.model.ProductResult
import java.util.*

/**
 * @author: swszz
 */
interface ProductReader {

    fun findById(id: UUID): ProductResult
    fun findAllByIds(ids: Set<UUID>): Collection<ProductResult>
}