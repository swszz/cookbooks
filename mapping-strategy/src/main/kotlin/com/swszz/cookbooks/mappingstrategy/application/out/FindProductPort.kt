package com.swszz.cookbooks.mappingstrategy.application.out

import com.swszz.cookbooks.mappingstrategy.domain.model.Product

/**
 * @author: swszz
 */
interface FindProductPort {
    fun findProductByIdCondition(condition: IdCondition): Product
    fun findProductsByIdConditions(conditions: Collection<IdCondition>): Collection<Product>
}