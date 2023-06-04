package com.swszz.cookbooks.meeting.infrastructure.jpa

import com.swszz.cookbooks.meeting.infrastructure.entity.relation.MeetingRecruiterUsers
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author: swszz
 */
interface MeetingRecruiterUsersJpaRepository : JpaRepository<MeetingRecruiterUsers, Long>