package com.swszz.cookbooks.meeting.infrastructure.entity

import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

/**
 * @author: swszz
 */
@Entity
class Meeting(
    @Column(name = "memo", nullable = true) var memo: String? = null,
    @Column(name = "address", length = 500, nullable = true) var address: String? = null,
    @Column(name = "address_category", nullable = false, updatable = false) val addressCategory: String,
    @Column(name = "status", nullable = false) var status: String,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JdbcTypeCode(SqlTypes.BIGINT)
    @Column(name = "id", nullable = false, updatable = false)
    val id: Long? = null
}