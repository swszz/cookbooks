package com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.entity

import jakarta.persistence.Embeddable
import java.io.Serializable
import java.util.*

/**
 * 해당 프로젝트에서 사용되는 모든 ID를 위한 클래스
 * @author: swszz
 */

@Embeddable
abstract class AbstractIdWithUUID(private val id: UUID) : Serializable
