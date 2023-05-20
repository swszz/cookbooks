package com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.entity

import com.fasterxml.uuid.Generators
import com.swszz.utils.kotlinEquals
import com.swszz.utils.kotlinHashCode
import com.swszz.utils.kotlinToString
import java.util.*

/**
 * @author: swszz
 */
class ProductDetailId
private constructor(val id: UUID) : AbstractIdWithUUID(id) {
    companion object {

        private val equalsAndHashCodeProperties = arrayOf(ProductDetailId::id)
        private val toStringProperties = arrayOf(ProductDetailId::id)
        fun of(uuid: String? = null): ProductDetailId {
            return uuid?.let {
                ProductDetailId(UUID.fromString(uuid))
            } ?: ProductDetailId(Generators.timeBasedGenerator().generate())
        }
    }

    override fun toString() = kotlinToString(properties = toStringProperties, superToString = { super.toString() })
    override fun equals(other: Any?) =
        kotlinEquals(other = other, properties = equalsAndHashCodeProperties, superEquals = { super.equals(other) })

    override fun hashCode() = kotlinHashCode(properties = equalsAndHashCodeProperties)

}