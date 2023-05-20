package com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.entity

import com.fasterxml.uuid.Generators
import java.util.*

/**
 * @author: swszz
 */
class ProductId
private constructor(private val id: UUID) : AbstractIdWithUUID(id) {
    companion object {
        fun of(uuid: String? = null): AbstractIdWithUUID {
            return uuid?.let {
                ProductId(UUID.fromString(uuid))
            } ?: ProductId(Generators.timeBasedGenerator().generate())
        }
    }
}