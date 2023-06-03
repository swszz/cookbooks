package com.swszz.cookbooks.meeting.infrastructure.entity.relation

import com.swszz.cookbooks.meeting.infrastructure.entity.AbstractEntity
import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

/**
 * @author: swszz
 */
@Entity
class MeetingOrganizerUsers(
    @Column(name = "organizer_user_id", nullable = false) val organizerUserId: Long,
    @Column(name = "meeting_id", nullable = false) val meetingId: Long,
) : AbstractEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JdbcTypeCode(SqlTypes.BIGINT)
    @Column(name = "id", nullable = false, updatable = false)
    val id: Long? = null
}