package com.swszz.cookbooks.meeting.domain.model

import com.swszz.cookbooks.meeting.domain.policy.MeetingTypePolicy.MAXIMUM_GROUP_MEETING_APPLICANT_SIZE
import com.swszz.cookbooks.meeting.domain.policy.MeetingTypePolicy.MAXIMUM_INDIVIDUAL_MEETING_APPLICANT_SIZE
import com.swszz.cookbooks.meeting.domain.policy.MeetingTypePolicy.MINIMUM_GROUP_MEETING_APPLICANT_SIZE
import com.swszz.cookbooks.meeting.domain.policy.MeetingTypePolicy.MINIMUM_INDIVIDUAL_MEETING_APPLICANT_SIZE

/**
 * 면접 타입
 * @author: swszz
 */

enum class MeetingType(
    private val minimumMeetingApplicantSize: Int,
    private val maximumMeetingApplicantSize: Int,
) {
    GROUP(
        MINIMUM_GROUP_MEETING_APPLICANT_SIZE, MAXIMUM_GROUP_MEETING_APPLICANT_SIZE
    ),
    INDIVIDUAL(
        MINIMUM_INDIVIDUAL_MEETING_APPLICANT_SIZE, MAXIMUM_INDIVIDUAL_MEETING_APPLICANT_SIZE
    );

    fun checkApplicants(applicants: Set<Applicant>) {
        if (applicants.size !in minimumMeetingApplicantSize..maximumMeetingApplicantSize) {
            throw IllegalStateException()
        }
    }
}