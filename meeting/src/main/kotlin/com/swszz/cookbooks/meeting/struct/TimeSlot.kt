package com.swszz.cookbooks.meeting.struct

import io.swagger.v3.oas.annotations.media.Schema
import java.time.ZonedDateTime

@Schema(description = "면접 일정 정보")
data class TimeSlot(
    @Schema(description = "면접 시작 시간") val startTime: ZonedDateTime,
    @Schema(description = "면접 종료 시간") val endTime: ZonedDateTime,
    @Schema(description = "캘린더 이메일") val resourceEmail: String? = null,
    @Schema(description = "캘린더에 등록된 리소스 이름") val generatedResourceName: String? = null,
)