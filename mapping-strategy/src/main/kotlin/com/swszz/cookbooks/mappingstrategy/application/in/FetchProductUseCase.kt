package com.swszz.cookbooks.mappingstrategy.application.`in`

/**
 * Product 조회 유즈케이스
 * @author: swszz
 */
interface FetchProductUseCase {
    /**
     * @Impl Product를 조회한다.
     */
    fun findProduct(query: DefaultProductQuery)


    /**
     * @Impl Collection<Product>을 조회한다.
     */
    fun findProducts(queries: Collection<DefaultProductQuery>)
}