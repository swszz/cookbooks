package com.swszz.kopring.beer.adapter.out.persistence.entity

import com.swszz.utils.kotlinToString
import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.Comment
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

/**
 * 생성 시간, 업데이트 시간 기록용 추상 엔티티
 * @author: swszz
 */
/* Data classes cannot be abstract, open, sealed, or inner.
 * -  https://kotlinlang.org/docs/data-classes.html
 */
@MappedSuperclass
abstract class AbstractAuditingEntity {

    @Comment("생성 시간")
    @Column(updatable = false, nullable = false)
    @CreationTimestamp
    private var createdDate: LocalDateTime? = null

    @Comment("마지막 업데이트 시간")
    @Column(updatable = true, nullable = false)
    @UpdateTimestamp
    private var updatedDate: LocalDateTime? = null


    override fun toString() = kotlinToString(
            properties = toStringProperties
    )

    companion object {
        private val toStringProperties = arrayOf(
                AbstractAuditingEntity::createdDate,
                AbstractAuditingEntity::updatedDate
        )
    }
}