package com.swszz.cookbooks.meeting.controller.request

import com.swszz.cookbooks.meeting.struct.Attachment
import com.swszz.cookbooks.meeting.struct.Mail
import com.swszz.cookbooks.meeting.struct.TimeSlot
import io.swagger.v3.oas.annotations.media.Schema

/**
 * @author: swszz
 */

@Schema(description = "면접 직접 등록")
data class DirectRegisterMeetingOfferRequest(
    @Schema(description = "워크스페이스(그룹) 고유 키") override val workspaceId: Long,
    @Schema(description = "공고 고유 키") override val openingId: Long,
    @Schema(description = "면접 생성 유저") override val organizerUserId: Long,
    @Schema(description = "지원자 고유 키 모음") override val applicantsIds: Set<Long> = emptySet(),
    @Schema(description = "면접관(유저) 고유 키 모음") override val recruiterIds: Set<Long> = emptySet(),
    @Schema(description = "면접 진행 시간") override val time: Int,
    @Schema(description = "메일 정보") override val content: Mail.Content,
    @Schema(description = "추가 정보") override val attachment: Attachment = Attachment(),
    @Schema(description = "면접 시작 & 종료 시간") val timeSlot: TimeSlot,
    @Schema(description = "메일 발송 여부") val enabledSendingMail: Boolean,
) : AbstractMeetingOfferRequest(
    workspaceId,
    openingId,
    organizerUserId,
    applicantsIds,
    recruiterIds,
    time,
    content,
    attachment
)