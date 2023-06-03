package com.swszz.cookbooks.meeting.infrastructure.entity

import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

/**
 * @author: swszz
 */
@Entity
class RescheduleMeetingOfferRequest(
    @Column(name = "meeting_offer_id", nullable = false, updatable = false) val meetingOfferId: Long,
    @Column(name = "message", nullable = false) val message: String,
) : AbstractEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JdbcTypeCode(SqlTypes.BIGINT)
    @Column(name = "id", nullable = false, updatable = false)
    val id: Long? = null
}