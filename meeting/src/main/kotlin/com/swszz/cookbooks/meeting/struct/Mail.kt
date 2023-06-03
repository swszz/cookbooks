package com.swszz.cookbooks.meeting.struct

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Email

class Mail {
    @Schema(description = "메일 콘텐츠")
    data class Content(
        @Schema(description = "제목") val title: String,
        @Schema(description = "본문") val body: String,
        @Schema(description = "참조") val cc: Set<Recipient> = emptySet(),
        @Schema(description = "숨음 참조") val bcc: Set<Recipient> = emptySet(),
        @Schema(description = "매직 링크 (mail.eve.att)") val magicLink: Set<String> = emptySet(),
        @Schema(description = "발행자") @field:Email(message = "메일 형식이 올바르지 않습니다.") val sender: String? = null,
    )

    @Schema(description = "수신자")
    data class Recipient(
        @Schema(description = "이름") val name: String,
        @Schema(description = "주소") val address: String,
    )
}