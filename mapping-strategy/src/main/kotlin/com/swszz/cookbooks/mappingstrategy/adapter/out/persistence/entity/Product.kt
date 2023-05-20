package com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.entity

import com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.listener.ProductEntityListener
import jakarta.persistence.*

/**
 * @author: swszz
 */

@Entity
@EntityListeners(ProductEntityListener::class)
class Product : AbstractAuditingEntity() {
    @EmbeddedId
    @Column(insertable = false, updatable = false)
    private var id: ProductId? = null
}