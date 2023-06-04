package com.swszz.cookbooks.meeting.domain.model

/**
 * @author: swszz
 */
data class Meeting(
    val type: MeetingType,
    val status: MeetingStatus,
    val memo: String?,
    val location: Location,
    val applicants: Set<Applicant>,
    val recruiters: Set<Recruiter>,
    val organizer: Organizer,
) {
    init {
        type.checkApplicants(applicants)
    }

    companion object {
        fun of(
            type: MeetingType,
            status: MeetingStatus,
            memo: String? = null,
            location: Location,
            applicants: Set<Applicant>,
            recruiters: Set<Recruiter>,
            organizer: Organizer,
        ): Meeting {
            return Meeting(
                type = type,
                status = status,
                memo = memo,
                location = location,
                applicants = applicants,
                recruiters = recruiters,
                organizer = organizer
            )
        }
    }
}