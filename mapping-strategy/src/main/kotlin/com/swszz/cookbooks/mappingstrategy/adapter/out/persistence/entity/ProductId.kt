package com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.entity

import com.fasterxml.uuid.Generators
import com.swszz.utils.kotlinEquals
import com.swszz.utils.kotlinHashCode
import com.swszz.utils.kotlinToString
import java.util.*

/**
 * @author: swszz
 */
class ProductId
private constructor(val id: UUID) : AbstractIdWithUUID(id) {
    companion object {

        private val equalsAndHashCodeProperties = arrayOf(ProductId::id)
        private val toStringProperties = arrayOf(ProductId::id)
        fun of(): ProductId {
            return ProductId(Generators.timeBasedGenerator().generate())
        }

        fun of(uuid: String? = null): ProductId {
            return uuid?.let {
                ProductId(UUID.fromString(uuid))
            } ?: throw IllegalArgumentException()
        }

        fun of(uuid: UUID? = null): ProductId {
            return uuid?.let {
                ProductId(uuid)
            } ?: throw IllegalArgumentException()
        }
    }


    override fun toString() = kotlinToString(properties = toStringProperties, superToString = { super.toString() })
    override fun equals(other: Any?) =
        kotlinEquals(other = other, properties = equalsAndHashCodeProperties, superEquals = { super.equals(other) })

    override fun hashCode() = kotlinHashCode(properties = equalsAndHashCodeProperties)

}