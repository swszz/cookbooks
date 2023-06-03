package com.swszz.cookbooks.meeting.infrastructure.jpa

import com.swszz.cookbooks.meeting.infrastructure.entity.RescheduleMeetingOfferRequest
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author: swszz
 */
interface RescheduleMeetingOfferRequestJpaRepository : JpaRepository<RescheduleMeetingOfferRequest, Long> {
}