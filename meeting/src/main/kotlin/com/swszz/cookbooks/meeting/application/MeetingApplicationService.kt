package com.swszz.cookbooks.meeting.application

import com.swszz.cookbooks.meeting.controller.request.DirectRegisterMeetingOfferRequest
import com.swszz.cookbooks.meeting.infrastructure.entity.Meeting
import com.swszz.cookbooks.meeting.infrastructure.entity.MeetingOffer
import com.swszz.cookbooks.meeting.infrastructure.entity.MeetingTimeSlot
import com.swszz.cookbooks.meeting.infrastructure.entity.TimeSlot
import com.swszz.cookbooks.meeting.infrastructure.entity.relation.MeetingApplicants
import com.swszz.cookbooks.meeting.infrastructure.entity.relation.MeetingOrganizerUsers
import com.swszz.cookbooks.meeting.infrastructure.entity.relation.MeetingRecruiterUsers
import com.swszz.cookbooks.meeting.infrastructure.entity.relation.OpeningMeetingOffers
import com.swszz.cookbooks.meeting.infrastructure.jpa.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * @author: swszz
 */

@Service
class MeetingApplicationService(
    private val meetingOfferRepository: MeetingOfferRepository,
    private val openingMeetingOfferRepository: OpeningMeetingOfferRepository,
    private val timeSlotRepository: TimeSlotRepository,
    private val meetingTimeSlotRepository: MeetingTimeSlotRepository,
    private val meetingJpaRepository: MeetingJpaRepository,
    private val meetingOrganizerUserJpaRepository: MeetingOrganizerUserJpaRepository,
    private val meetingRecruiterUsersJpaRepository: MeetingRecruiterUsersJpaRepository,
    private val meetingApplicantsJpaRepository: MeetingApplicantsJpaRepository,
) {

    @Transactional
    fun sendMeetingOfferDirectly(directRegisterMeetingOfferRequest: DirectRegisterMeetingOfferRequest) {
        // 미팅 오퍼 생성
        val openingId: Long = directRegisterMeetingOfferRequest.openingId.toLong()
        val meetingOffer: MeetingOffer = this.meetingOfferRepository.save(MeetingOffer())

        // 타임 슬롯 생성
        val timeSlot: TimeSlot = this.timeSlotRepository.save(
            TimeSlot(
                meetingOfferId = meetingOffer.id!!,
                startTime = directRegisterMeetingOfferRequest.timeSlot.startTime,
                endTime = directRegisterMeetingOfferRequest.timeSlot.endTime,
                resourceEmail = directRegisterMeetingOfferRequest.timeSlot.resourceEmail,
                timezone = directRegisterMeetingOfferRequest.time,
                generatedResourceName = directRegisterMeetingOfferRequest.timeSlot.generatedResourceName,
                registered = true
            )
        )

        // 관계 테이블 생성
        val openingMeetingOffers: OpeningMeetingOffers = this.openingMeetingOfferRepository.save(
            OpeningMeetingOffers(
                openingId = openingId, meetingOfferId = meetingOffer.id!!
            )
        )
        // 오퍼 생성 이벤트 발행

        // 면접 생성
        val meeting: Meeting = this.meetingJpaRepository.save(
            Meeting(
                memo = directRegisterMeetingOfferRequest.attachment.memo,
                address = directRegisterMeetingOfferRequest.attachment.location.address,
                addressCategory = directRegisterMeetingOfferRequest.attachment.location.category,
                status = "status"
            )
        )

        // 면접-주최자 생성
        val meetingOrganizerUser: MeetingOrganizerUsers = this.meetingOrganizerUserJpaRepository.save(
            MeetingOrganizerUsers(
                organizerUserId = directRegisterMeetingOfferRequest.organizerUserId, meetingId = meeting.id!!
            )
        )

        // 면접-면접관 생성
        val meetingRecruiterUsers: List<MeetingRecruiterUsers> =
            this.meetingRecruiterUsersJpaRepository.saveAll(directRegisterMeetingOfferRequest.recruiterIds.map {
                MeetingRecruiterUsers(
                    meetingId = meeting.id!!, recruiterUserId = it
                )
            })

        // 면접-지원자 생성
        val meetingApplicants: List<MeetingApplicants> =
            this.meetingApplicantsJpaRepository.saveAll(directRegisterMeetingOfferRequest.applicantsIds.map {
                MeetingApplicants(
                    meetingId = meeting.id!!, applicantId = it
                )
            })
        // 면접 생성 이벤트 발행

        
        // 시간 변경은 여기만 처리하면 됨...
        // 미팅 시간 연결
        val meetingTimeSlot: MeetingTimeSlot = this.meetingTimeSlotRepository.save(
            MeetingTimeSlot(meetingId = meeting.id!!, timeSlotId = timeSlot.id!!)
        )

        // 면접 확정 이벤트 생성
    }
}