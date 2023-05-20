package com.swszz.cookbooks.mappingstrategy.domain

import com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.ProductReader
import com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.model.ProductResult
import com.swszz.cookbooks.mappingstrategy.application.out.FindProductDetailPort
import com.swszz.cookbooks.mappingstrategy.application.out.FindProductPort
import com.swszz.cookbooks.mappingstrategy.application.out.IdCondition
import com.swszz.cookbooks.mappingstrategy.domain.model.ProductData
import org.springframework.stereotype.Service

/**
 * @author: swszz
 */


@Service
class ProductService(
    private val productReader: ProductReader,
) : FindProductPort, FindProductDetailPort {

    private val productDataMapper: ProductDataMapper = ProductDataMapper.INSTANCE
    override fun findProductByIdCondition(condition: IdCondition): ProductData {
        val result: ProductResult = productReader.findById(condition.getId())
        return productDataMapper.toProductData(result)
    }

    override fun findProductsByIdConditions(conditions: Collection<IdCondition>): Collection<ProductData> {
        TODO("Not yet implemented")
    }

}