package com.swszz.cookbooks.meeting.infrastructure.entity.relation

import com.swszz.cookbooks.meeting.infrastructure.entity.AbstractEntity
import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

/**
 * @author: swszz
 */
@Entity
class MeetingOfferApplicants(
    @Column(name = "meeting_offer_id", nullable = false) val meetingOfferId: Long,
    @Column(name = "applicant_id", nullable = false) val applicantId: Long,
) : AbstractEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JdbcTypeCode(SqlTypes.BIGINT)
    @Column(name = "id", nullable = false, updatable = false)
    val id: Long? = null
}