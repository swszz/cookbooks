package com.swszz.cookbooks.meeting.struct

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "면접 장소")
data class Location(
    @Schema(description = "주소") val address: String? = null,
    @Schema(description = "카테고리") val category: String = "default",
)