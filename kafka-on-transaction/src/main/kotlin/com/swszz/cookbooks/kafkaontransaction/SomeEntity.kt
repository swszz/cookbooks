package com.swszz.cookbooks.kafkaontransaction

import jakarta.persistence.*
import org.hibernate.annotations.Comment

/**
 * 테스트 전용 엔티티
 * @author: swszz
 */
@Entity
open class SomeEntity {
    @Comment("Primary Key")
    @Id
    @Column(updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null
}