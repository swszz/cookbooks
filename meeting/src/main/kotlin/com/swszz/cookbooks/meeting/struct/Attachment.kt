package com.swszz.cookbooks.meeting.struct

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "추가 정보")
data class Attachment(
    @Schema(description = "메모") val memo: String? = null,
    @Schema(description = "면접 장소") val location: Location = Location(),
    @Schema(description = "캘린더 자동 갱신") val autoUpdateByRecruitmentSchedules: Boolean = false,
)