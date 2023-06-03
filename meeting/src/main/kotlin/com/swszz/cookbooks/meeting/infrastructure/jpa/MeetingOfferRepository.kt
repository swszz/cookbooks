package com.swszz.cookbooks.meeting.infrastructure.jpa

import com.swszz.cookbooks.meeting.infrastructure.entity.MeetingOffer
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author: swszz
 */
interface MeetingOfferRepository : JpaRepository<MeetingOffer, Long>