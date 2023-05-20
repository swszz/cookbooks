package com.swszz.cookbooks.mappingstrategy.application.out

import java.util.*

/**
 * @author: swszz
 */
class DefaultProductIdCondition private constructor(
    private val id: UUID,
) : AbstractCondition(), IdCondition {

    companion object {
        fun of(id: UUID): IdCondition {
            return DefaultProductIdCondition(id)
        }
    }

    override fun getId(): UUID {
        return id
    }
}