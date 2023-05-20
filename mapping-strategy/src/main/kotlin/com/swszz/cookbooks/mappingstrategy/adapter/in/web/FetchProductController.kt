package com.swszz.cookbooks.mappingstrategy.adapter.`in`.web

import com.swszz.cookbooks.mappingstrategy.adapter.`in`.web.model.ProductDetail
import com.swszz.cookbooks.mappingstrategy.application.`in`.DefaultProductQuery
import com.swszz.cookbooks.mappingstrategy.application.`in`.FetchProductUseCase
import com.swszz.cookbooks.mappingstrategy.application.`in`.ProductIdQuery
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

/**
 * @author: swszz
 */

@RestController
class FetchProductController(private val fetchProductUseCase: FetchProductUseCase) {

    @GetMapping("product/{productId}")
    fun fetchProduct(@PathVariable productId: String): ResponseEntity<com.swszz.cookbooks.mappingstrategy.adapter.`in`.web.model.Product> {
        val query: ProductIdQuery = DefaultProductQuery.of(productId)
        val product: com.swszz.cookbooks.mappingstrategy.domain.model.Product = fetchProductUseCase.findProduct(query)
        return ResponseEntity.ok(
            com.swszz.cookbooks.mappingstrategy.adapter.`in`.web.model.Product(
                product.id, ProductDetail(
                    product.productDetail.id,
                    product.productDetail.price,
                    product.productDetail.createdAt,
                    product.productDetail.createdAt
                ), product.createdAt, product.createdAt
            )
        )
    }
}