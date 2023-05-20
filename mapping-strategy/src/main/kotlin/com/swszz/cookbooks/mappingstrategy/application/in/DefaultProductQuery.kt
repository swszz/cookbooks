package com.swszz.cookbooks.mappingstrategy.application.`in`

import java.util.*

/**
 * product를 aggregate root로 사용하는 기본 조회 쿼리
 * @author: swszz
 */
class DefaultProductQuery private constructor(private val id: UUID) : AbstractProductQuery(), ProductIdQuery {
    companion object {
        fun of(id: Any): ProductIdQuery {
            return when (id) {
                is String -> DefaultProductQuery(UUID.fromString(id))
                is UUID -> DefaultProductQuery(id)
                else -> throw IllegalArgumentException()
            }
        }
    }

    override fun getId(): UUID {
        return this.id
    }
}