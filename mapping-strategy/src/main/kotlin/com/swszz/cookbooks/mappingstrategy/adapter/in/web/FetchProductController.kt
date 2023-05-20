package com.swszz.cookbooks.mappingstrategy.adapter.`in`.web

import com.swszz.cookbooks.mappingstrategy.adapter.`in`.web.model.Product
import com.swszz.cookbooks.mappingstrategy.application.`in`.DefaultProductQuery
import com.swszz.cookbooks.mappingstrategy.application.`in`.FetchProductUseCase
import com.swszz.cookbooks.mappingstrategy.application.`in`.ProductIdQuery
import com.swszz.cookbooks.mappingstrategy.domain.model.ProductData
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
    fun fetchProduct(@PathVariable productId: String): ResponseEntity<Product> {
        val query: ProductIdQuery = DefaultProductQuery.of(productId)
        val productData: ProductData = fetchProductUseCase.findProduct(query)
        return ResponseEntity.ok(Product(productData.id, productData.createdAt, productData.createdAt))
    }
}