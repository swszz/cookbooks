package com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.listener

import com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.entity.AbstractAuditingEntity
import jakarta.persistence.PreRemove
import java.time.LocalDateTime
import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible

/**
 * AuditingEntityListener
 * @author: swszz
 */
class AuditingEntityListener {
    @PreRemove
    fun preRemove(o: Any? = null): Unit {
        requireNotNull(o)
        if (o is AbstractAuditingEntity) {
            // private property 에 대한 접근 권한 및 데이터 세팅
            val key = o::class.memberProperties.find { it.name == "deletedAt" }
            if (key is KMutableProperty<*>) {
                key.let {
                    it.isAccessible = true
                    it.setter.call(o, LocalDateTime.now())
                }
            }
        }
    }
}