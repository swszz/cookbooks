package com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.entity

import com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.listener.ProductDetailEntityListener
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne

/**
 * @author: swszz
 */

@Entity
@EntityListeners(ProductDetailEntityListener::class)
class ProductDetail(
    @EmbeddedId
    @Column(insertable = false, updatable = false)
    var id: ProductDetailId? = null,
    @Column(nullable = false)
    var price: Long = 0L,
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "product_id")
    var product: Product,
) : AbstractAuditingEntity() {
    init {
        this.product.productDetail = this
    }
}