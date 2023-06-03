package com.swszz.cookbooks.meeting.infrastructure.entity.relation

import com.swszz.cookbooks.meeting.infrastructure.entity.AbstractEntity
import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes


/**
 * @author: swszz
 */

@Entity
class OpeningMeetingOffers(
    @Column(name = "opening_id", nullable = false, updatable = false) val openingId: Long,
    @Column(name = "meeting_offer_id", nullable = false, updatable = false) val meetingOfferId: Long,
) : AbstractEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JdbcTypeCode(SqlTypes.BIGINT)
    @Column(name = "id", nullable = false, updatable = false)
    val id: Long? = null
}