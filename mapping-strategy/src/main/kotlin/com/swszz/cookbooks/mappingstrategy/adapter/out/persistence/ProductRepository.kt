package com.swszz.cookbooks.mappingstrategy.adapter.out.persistence

import com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.entity.Product
import com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.entity.ProductDetail
import com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.entity.ProductId
import com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.jpa.ProductDetailJpaRepository
import com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.jpa.ProductJpaRepository
import com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.model.ProductData
import com.swszz.cookbooks.mappingstrategy.domain.ProductReader
import jakarta.persistence.EntityNotFoundException
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Repository
import java.util.*

/**
 * @author: swszz
 */

@Repository
class ProductRepository
    (
    private val productJpaRepository: ProductJpaRepository,
    private val productDetailJpaRepository: ProductDetailJpaRepository,
) : ProductReader {
    private val productEntityMapper: ProductEntityMapper = ProductEntityMapper.INSTANCE
    override fun findById(id: UUID): ProductData {
        val entity: Product = productJpaRepository.findById(ProductId.of(id)).orElseThrow(::EntityNotFoundException)
        return productEntityMapper.toProductData(entity)
    }

    override fun findAllByIds(ids: Set<UUID>): Collection<ProductData> {
        val entities: Collection<Product> = productJpaRepository.findAllById(ids.map { ProductId.of(it) })
        return entities.map { productEntityMapper.toProductData(it) }
    }

    @EventListener(ApplicationReadyEvent::class)
    fun setupDummyEntities() {
        for (i in 1..10) {
            val product: Product = Product()
            val productDetail: ProductDetail = ProductDetail(product = product)
            productDetailJpaRepository.save(productDetail)
        }
    }
}