package com.swszz.cookbooks.dddwithhexagonal.common.entity.listener

import com.swszz.cookbooks.dddwithhexagonal.common.entity.AbstractAuditingEntity
import com.swszz.cookbooks.dddwithhexagonal.common.entity.Id
import jakarta.persistence.PrePersist
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
    @PrePersist
    fun prePersist(o: Any? = null): Unit {
        requireNotNull(o)
        if (o is AbstractAuditingEntity) {
            // private property 에 대한 접근 권한 및 데이터 세팅
            val key = o::class.memberProperties.find { it.name == "id" }
            println(o::class.memberProperties)
            if (key is KMutableProperty<*>) {
                key.let {
                    it.isAccessible = true
                    it.setter.call(o, Id.of())
                }
            }
        }
    }

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