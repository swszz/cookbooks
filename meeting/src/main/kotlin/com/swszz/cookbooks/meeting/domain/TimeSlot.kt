package com.swszz.cookbooks.meeting.domain

import java.time.ZonedDateTime

/**
 * @author: swszz
 */
class TimeSlot(
    val startTime: ZonedDateTime,
    val endTime: ZonedDateTime,
) {
    private val selected: Boolean = false
}