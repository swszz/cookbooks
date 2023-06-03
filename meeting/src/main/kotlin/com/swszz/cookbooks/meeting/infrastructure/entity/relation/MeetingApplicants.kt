package com.swszz.cookbooks.meeting.infrastructure.entity.relation

import com.swszz.cookbooks.meeting.infrastructure.entity.AbstractEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

/**
 * @author: swszz
 */

@Entity
class MeetingApplicants(
    @Column(name = "meeting_id", nullable = false) val meetingId: Long,
    @Column(name = "applicant_id", nullable = false) val applicantId: Long,
) : AbstractEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JdbcTypeCode(SqlTypes.BIGINT)
    @Column(name = "id", nullable = false, updatable = false)
    val id: Long? = null
}