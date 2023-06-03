package com.swszz.cookbooks.meeting.infrastructure.jpa

import com.swszz.cookbooks.meeting.infrastructure.entity.relation.OpeningMeetingOffers
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author: swszz
 */
interface OpeningMeetingOfferRepository : JpaRepository<OpeningMeetingOffers, Long> {
}