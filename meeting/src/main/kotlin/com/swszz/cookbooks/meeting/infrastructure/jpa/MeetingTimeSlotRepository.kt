package com.swszz.cookbooks.meeting.infrastructure.jpa

import com.swszz.cookbooks.meeting.infrastructure.entity.MeetingTimeSlot
import com.swszz.cookbooks.meeting.infrastructure.entity.TimeSlot
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author: swszz
 */
interface MeetingTimeSlotRepository : JpaRepository<MeetingTimeSlot, Long>