package com.swszz.cookbooks.meeting.infrastructure.entity

import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.time.ZonedDateTime

/**
 * @author: swszz
 */

@Entity
class MeetingTimeSlot(
    @Column(name = "meeting_id", nullable = false, updatable = false) val meetingId: Long,
    @Column(name = "timeslot_id", nullable = false) val timeSlotId: Long,
) : AbstractEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JdbcTypeCode(SqlTypes.BIGINT)
    @Column(name = "id", nullable = false, updatable = false)
    val id: Long? = null
}