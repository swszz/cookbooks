package com.swszz.cookbooks.mappingstrategy.application.`in`

import com.swszz.cookbooks.mappingstrategy.domain.model.Product

/**
 * Product 조회 유즈케이스
 * @author: swszz
 */
interface FetchProductUseCase {
    /**
     * @Impl Product를 조회한다.
     */
    fun findProduct(query: ProductIdQuery): Product


    /**
     * @Impl Collection<Product>을 조회한다.
     */
    fun findProducts(queries: Collection<ProductIdQuery>): Collection<Product>
}