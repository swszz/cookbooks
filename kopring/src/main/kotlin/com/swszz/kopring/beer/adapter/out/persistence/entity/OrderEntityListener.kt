package com.swszz.kopring.beer.adapter.out.persistence.entity

import jakarta.persistence.PrePersist
import java.util.*
import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible

/**
 * 주문 테이블 전용 entity listener
 * @author: swszz
 */
class OrderEntityListener {
    @PrePersist
    fun prePersist(o: Any? = null): Unit {
        requireNotNull(o)
        if (o is Order) {
            // private property 에 대한 접근 권한 및 데이터 세팅 (Entity 의 모든 property 는 private 이어야 한다는 생각)
            val key = o::class.memberProperties.find { it.name == "key" }
            if (key is KMutableProperty<*>) {
                key.let {
                    it.isAccessible = true
                    it.setter.call(o, UUID.randomUUID().toString())
                }
            }
        }
    }
}