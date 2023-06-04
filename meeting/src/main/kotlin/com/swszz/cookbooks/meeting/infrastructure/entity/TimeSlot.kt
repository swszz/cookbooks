package com.swszz.cookbooks.meeting.infrastructure.entity

import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.time.ZonedDateTime

/**
 * @author: swszz
 */

@Entity
class TimeSlot(
    @Column(name = "meeting_offer_id", nullable = false, updatable = false) val meetingOfferId: Long,
    @Column(name = "start_time", nullable = false, updatable = false) val startTime: ZonedDateTime,
    @Column(name = "end_time", nullable = false, updatable = false) val endTime: ZonedDateTime,
    @Column(name = "timezone", nullable = false) val timezone: Int,
    @Column(name = "resource_email", length = 500) val resourceEmail: String? = null,
    // 이메일로 생성 (받아서 올 수는 없는가?)
    @Column(name = "generated_resource_name", length = 1000) val generatedResourceName: String? = null,
    @Column(name = "registered", nullable = false) val registered: Boolean = false,
) : AbstractEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JdbcTypeCode(SqlTypes.BIGINT)
    @Column(name = "id", nullable = false, updatable = false)
    val id: Long? = null
}