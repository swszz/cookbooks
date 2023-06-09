package com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.listener

import com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.entity.Product
import com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.entity.ProductId
import jakarta.persistence.PrePersist
import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible

/**
 * @author: swszz
 */
class ProductEntityListener {
    @PrePersist
    fun prePersist(o: Any? = null): Unit {
        requireNotNull(o)
        if (o is Product) {
            // private property 에 대한 접근 권한 및 데이터 세팅
            val key = o::class.memberProperties.find { it.name == "id" }
            if (key is KMutableProperty<*>) {
                key.run {
                    key.isAccessible = true
                    key.setter.call(o, ProductId.of())
                }
            }
        }
    }
}