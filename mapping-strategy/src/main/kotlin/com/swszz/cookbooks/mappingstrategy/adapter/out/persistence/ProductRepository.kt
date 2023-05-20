package com.swszz.cookbooks.mappingstrategy.adapter.out.persistence

import com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.entity.Product
import com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.entity.ProductId
import com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.jpa.ProductJpaRepository
import com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.model.ProductResult
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
) : ProductReader {
    private val productMapper: ProductMapper = ProductMapper.INSTANCE
    override fun findById(id: UUID): ProductResult {
        val entity: Product = productJpaRepository.findById(ProductId.of(id)).orElseThrow(::EntityNotFoundException)
        return productMapper.toProductResult(entity)
    }

    override fun findAllByIds(ids: Set<UUID>): Collection<ProductResult> {
        val entities: Collection<Product> = productJpaRepository.findAllById(ids.map { ProductId.of(it) })
        return entities.map { productMapper.toProductResult(it) }
    }


    @EventListener(ApplicationReadyEvent::class)
    fun setupDummyEntities() {
        for (i in 1..10) {
            productJpaRepository.save(Product())
        }
    }
}