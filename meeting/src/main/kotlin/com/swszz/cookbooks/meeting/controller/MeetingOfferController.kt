package com.swszz.cookbooks.meeting.controller

import com.swszz.cookbooks.meeting.controller.request.DefaultRegisterMeetingOfferRequest
import com.swszz.cookbooks.meeting.controller.request.DirectRegisterMeetingOfferRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author: swszz
 */

@RequestMapping("meeting/offer")
@RestController
class MeetingOfferController {

    @PostMapping("direct")
    fun directRegisterMeetingOffer(@RequestBody directRegisterMeetingOfferRequest: DirectRegisterMeetingOfferRequest) {
        print(directRegisterMeetingOfferRequest)
    }

    @PostMapping
    fun registerMeetingOffer(@RequestBody defaultRegisterMeetingOfferRequest: DefaultRegisterMeetingOfferRequest) {
        print(defaultRegisterMeetingOfferRequest)
    }
}