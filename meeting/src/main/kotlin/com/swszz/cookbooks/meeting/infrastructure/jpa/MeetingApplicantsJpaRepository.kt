package com.swszz.cookbooks.meeting.infrastructure.jpa

import com.swszz.cookbooks.meeting.infrastructure.entity.relation.MeetingApplicants
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author: swszz
 */
interface MeetingApplicantsJpaRepository : JpaRepository<MeetingApplicants, Long>