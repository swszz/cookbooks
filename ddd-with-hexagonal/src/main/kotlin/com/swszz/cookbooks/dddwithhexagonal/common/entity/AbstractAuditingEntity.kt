package com.swszz.cookbooks.dddwithhexagonal.common.entity

import com.swszz.cookbooks.dddwithhexagonal.common.entity.listener.AuditingEntityListener
import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import kotlinToString
import org.hibernate.annotations.Comment
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

/**
 * 생성 시간, 업데이트 시간 기록용 추상 엔티티
 * @author: swszz
 * ---
 * Data classes cannot be abstract, open, sealed, or inner.
 * -  https://kotlinlang.org/docs/data-classes.html
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class AbstractAuditingEntity {

    @Comment("생성 시간")
    @Column(updatable = false, nullable = false)
    @CreationTimestamp
    private var createdAt: LocalDateTime? = null

    @Comment("마지막 업데이트 시간")
    @Column(updatable = true, nullable = false)
    @UpdateTimestamp
    private var updatedAt: LocalDateTime? = null

    @Comment("삭제 시간")
    @Column(updatable = true, nullable = true)
    private var deletedAt: LocalDateTime? = null

    override fun toString() = kotlinToString(
        properties = toStringProperties
    )

    companion object {
        private val toStringProperties = arrayOf(
            AbstractAuditingEntity::createdAt,
            AbstractAuditingEntity::updatedAt,
            AbstractAuditingEntity::deletedAt,
        )
    }
}