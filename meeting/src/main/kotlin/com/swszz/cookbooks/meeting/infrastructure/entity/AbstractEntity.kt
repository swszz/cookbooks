package com.swszz.cookbooks.meeting.infrastructure.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.Comment
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

/**
 * @author: swszz
 */
@MappedSuperclass
abstract class AbstractEntity {
    @Comment("생성 시간")
    @Column(updatable = false, nullable = false)
    @CreationTimestamp
    val createdAt: LocalDateTime? = null

    @Comment("마지막 업데이트 시간")
    @Column(updatable = true, nullable = false)
    @UpdateTimestamp
    val updatedAt: LocalDateTime? = null

    @Comment("삭제 시간")
    @Column(updatable = true, nullable = true)
    val deletedAt: LocalDateTime? = null
}