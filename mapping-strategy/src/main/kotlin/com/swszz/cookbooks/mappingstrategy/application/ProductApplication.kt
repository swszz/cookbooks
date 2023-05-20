package com.swszz.cookbooks.mappingstrategy.application

import com.swszz.cookbooks.mappingstrategy.application.`in`.DefaultProductQuery
import com.swszz.cookbooks.mappingstrategy.application.`in`.FetchProductUseCase
import org.springframework.stereotype.Service

/**
 * @author: swszz
 */

@Service
class ProductApplication(
) : FetchProductUseCase {
    override fun findProduct(query: DefaultProductQuery) {
        TODO("Not yet implemented")
    }

    override fun findProducts(queries: Collection<DefaultProductQuery>) {
        TODO("Not yet implemented")
    }
}