package com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.entity

import com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.listener.ProductDetailEntityListener
import jakarta.persistence.Column
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners

/**
 * @author: swszz
 */

@Entity
@EntityListeners(ProductDetailEntityListener::class)
class ProductDetail : AbstractAuditingEntity() {
    @EmbeddedId
    @Column(insertable = false, updatable = false)
    private var id: ProductDetailId? = null
}