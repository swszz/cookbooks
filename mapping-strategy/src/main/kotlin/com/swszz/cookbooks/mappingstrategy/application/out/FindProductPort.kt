package com.swszz.cookbooks.mappingstrategy.application.out

import com.swszz.cookbooks.mappingstrategy.domain.model.ProductData

/**
 * @author: swszz
 */
interface FindProductPort {
    fun findProductByIdCondition(condition: IdCondition): ProductData
    fun findProductsByIdConditions(conditions: Collection<IdCondition>): Collection<ProductData>
}