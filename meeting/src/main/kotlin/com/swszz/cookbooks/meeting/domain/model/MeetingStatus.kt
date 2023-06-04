package com.swszz.cookbooks.meeting.domain.model

import com.swszz.cookbooks.meeting.domain.policy.MeetingStatusPolicy

/**
 * 면접 상태
 * @author: swszz
 */

enum class MeetingStatus(private val code: Int) {
    CREATE(MeetingStatusPolicy.CREATE),
    REQUEST_CHANGE(MeetingStatusPolicy.REQUEST_CHANGE),
    CONFIRM(MeetingStatusPolicy.CONFIRM),
}