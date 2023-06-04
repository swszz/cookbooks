package com.swszz.cookbooks.meeting.infrastructure.jpa

import com.swszz.cookbooks.meeting.infrastructure.entity.relation.MeetingOrganizerUsers
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author: swszz
 */
interface MeetingOrganizerUserJpaRepository : JpaRepository<MeetingOrganizerUsers, Long>