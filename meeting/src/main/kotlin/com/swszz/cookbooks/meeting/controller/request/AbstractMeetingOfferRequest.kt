package com.swszz.cookbooks.meeting.controller.request

import com.swszz.cookbooks.meeting.struct.Attachment
import com.swszz.cookbooks.meeting.struct.Mail
import io.swagger.v3.oas.annotations.media.Schema

/**
 * @author: swszz
 */
abstract class AbstractMeetingOfferRequest(
    @Schema(description = "면접 타입") open val meetingType: String,
    @Schema(description = "워크스페이스(그룹) 고유 키") open val workspaceId: Long,
    @Schema(description = "공고 고유 키") open val openingId: Long,
    @Schema(description = "미팅 생성 유저") open val organizerUserId: Long,
    @Schema(description = "지원자 고유 키 모음") open val applicantsIds: Set<Long> = emptySet(),
    @Schema(description = "면접관(유저) 고유 키 모음") open val recruiterIds: Set<Long> = emptySet(),
    @Schema(description = "면접 진행 시간") open val time: Int,
    @Schema(description = "메일 정보") open val content: Mail.Content,
    @Schema(description = "추가 정보") open val attachment: Attachment = Attachment(),
)