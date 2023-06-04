package com.swszz.cookbooks.meeting.controller

import com.swszz.cookbooks.meeting.application.MeetingApplicationService
import com.swszz.cookbooks.meeting.controller.request.DefaultRegisterMeetingOfferRequest
import com.swszz.cookbooks.meeting.controller.request.DirectRegisterMeetingOfferRequest
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author: swszz
 */

@RequestMapping("meeting/offer")
@RestController
class MeetingOfferController(
    private val meetingApplicationService: MeetingApplicationService,
) {

    @PostMapping("direct")
    fun directRegisterMeetingOffer(@Valid @RequestBody directRegisterMeetingOfferRequest: DirectRegisterMeetingOfferRequest) {
        meetingApplicationService.sendMeetingOfferDirectly(directRegisterMeetingOfferRequest)
    }

    @PostMapping
    fun registerMeetingOffer(@Valid @RequestBody defaultRegisterMeetingOfferRequest: DefaultRegisterMeetingOfferRequest) {
        print(defaultRegisterMeetingOfferRequest)
    }
}