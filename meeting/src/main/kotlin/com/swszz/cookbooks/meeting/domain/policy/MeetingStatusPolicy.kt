package com.swszz.cookbooks.meeting.domain.policy

/**
 * @author: swszz
 */
object MeetingStatusPolicy {
    const val CREATE: Int = 0
    const val REQUEST_CHANGE: Int = 100
    const val CONFIRM: Int = 200
}