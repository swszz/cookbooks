package com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.entity

import com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.listener.ProductEntityListener
import com.swszz.utils.kotlinEquals
import com.swszz.utils.kotlinHashCode
import com.swszz.utils.kotlinToString
import jakarta.persistence.*

/**
 * @author: swszz
 */

@Entity
@EntityListeners(ProductEntityListener::class)
class Product(
    @EmbeddedId
    @Column(insertable = false, updatable = false)
    var id: ProductId? = null,
    @OneToOne(mappedBy = "product")
    var productDetail: ProductDetail? = null,
) : AbstractAuditingEntity() {

    override fun toString() = kotlinToString(properties = toStringProperties, superToString = { super.toString() })
    override fun equals(other: Any?) = kotlinEquals(other = other, properties = equalsAndHashCodeProperties)
    override fun hashCode() = kotlinHashCode(properties = equalsAndHashCodeProperties)

    companion object {
        private val equalsAndHashCodeProperties = arrayOf(Product::id)
        private val toStringProperties = arrayOf(Product::id)
    }
}