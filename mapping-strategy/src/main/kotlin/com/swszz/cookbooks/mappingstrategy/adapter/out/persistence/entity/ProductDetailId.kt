package com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.entity

import com.fasterxml.uuid.Generators
import java.util.*

/**
 * @author: swszz
 */
class ProductDetailId
private constructor(private val id: UUID) : AbstractIdWithUUID(id) {
    companion object {
        fun of(uuid: String? = null): AbstractIdWithUUID {
            return uuid?.let {
                ProductDetailId(UUID.fromString(uuid))
            } ?: ProductDetailId(Generators.timeBasedGenerator().generate())
        }
    }
}