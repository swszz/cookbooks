package com.swszz.cookbooks.meeting.domain.policy

/**
 * @author: swszz
 */
object MeetingTypePolicy {
    const val MINIMUM_INDIVIDUAL_MEETING_APPLICANT_SIZE: Int = 1
    const val MAXIMUM_INDIVIDUAL_MEETING_APPLICANT_SIZE: Int = 1

    const val MINIMUM_GROUP_MEETING_APPLICANT_SIZE: Int = 1
    const val MAXIMUM_GROUP_MEETING_APPLICANT_SIZE: Int = Int.MAX_VALUE
}