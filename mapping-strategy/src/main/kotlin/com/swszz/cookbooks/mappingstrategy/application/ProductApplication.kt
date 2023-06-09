package com.swszz.cookbooks.mappingstrategy.application

import com.swszz.cookbooks.mappingstrategy.application.`in`.FetchProductUseCase
import com.swszz.cookbooks.mappingstrategy.application.`in`.ProductIdQuery
import com.swszz.cookbooks.mappingstrategy.application.out.DefaultProductIdCondition
import com.swszz.cookbooks.mappingstrategy.domain.ProductService
import com.swszz.cookbooks.mappingstrategy.domain.model.Product
import org.springframework.stereotype.Service

/**
 * @author: swszz
 */

@Service
class ProductApplication(
    private val productService: ProductService,
) : FetchProductUseCase {
    override fun findProduct(query: ProductIdQuery): Product {
        return productService.findProductByIdCondition(
            DefaultProductIdCondition.of(query.getId())
        )
    }

    override fun findProducts(queries: Collection<ProductIdQuery>): Collection<Product> {
        TODO("Not yet implemented")
    }

}