package com.swszz.cookbooks.mappingstrategy.domain

import com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.model.ProductData
import com.swszz.cookbooks.mappingstrategy.application.out.FindProductPort
import com.swszz.cookbooks.mappingstrategy.application.out.IdCondition
import com.swszz.cookbooks.mappingstrategy.domain.model.Product
import org.springframework.stereotype.Service

/**
 * @author: swszz
 */


@Service
class ProductService(
    private val productReader: ProductReader,
) : FindProductPort {

    private val productDataMapper: ProductDataMapper = ProductDataMapper.INSTANCE
    override fun findProductByIdCondition(condition: IdCondition): Product {
        val productData: ProductData = productReader.findById(condition.getId())
        return productDataMapper.toProduct(productData)
    }

    override fun findProductsByIdConditions(conditions: Collection<IdCondition>): Collection<Product> {
        val productDatas: Collection<ProductData> = productReader.findAllByIds(conditions.map { it.getId() }.toSet())
        return productDatas.map { productDataMapper.toProduct(it) }
    }
}