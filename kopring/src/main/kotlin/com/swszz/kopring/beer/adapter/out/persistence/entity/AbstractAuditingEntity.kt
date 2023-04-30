package com.swszz.kopring.beer.adapter.out.persistence.entity

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
}