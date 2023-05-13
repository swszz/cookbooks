package com.swszz.cookbooks.dddwithhexagonal.common.entity

import com.fasterxml.uuid.Generators
import jakarta.persistence.Embeddable
import java.io.Serializable
import java.util.*

/**
 * 해당 프로젝트에서 사용되는 모든 ID를 위한 클래스
 * @author: swszz
 */

@Embeddable
class Id
private constructor(private val id: UUID) : Serializable {
    companion object {
        fun of(uuid: String? = null): Id {
            return uuid?.let {
                Id(UUID.fromString(uuid))
            } ?: Id(Generators.timeBasedGenerator().generate())
        }
    }
}