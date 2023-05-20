package com.swszz.cookbooks.mappingstrategy.application.`in`

import java.util.UUID

/**
 * product를 aggregate root로 사용하는 기본 조회 쿼리
 * @author: swszz
 */
class DefaultProductQuery private constructor(private val id: Any) : AbstractProductQuery() {
    companion object {
        fun of(id: Any): DefaultProductQuery {
            return DefaultProductQuery(id)
        }
    }
}