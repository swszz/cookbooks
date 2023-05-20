package com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.entity

import com.swszz.utils.kotlinEquals
import com.swszz.utils.kotlinHashCode
import com.swszz.utils.kotlinToString
import jakarta.persistence.Embeddable
import java.io.Serializable
import java.util.*

/**
 * 해당 프로젝트에서 사용되는 모든 ID를 위한 클래스
 * @author: swszz
 */

@Embeddable
abstract class AbstractIdWithUUID(private val id: UUID) : Serializable {

    companion object {
        private val equalsAndHashCodeProperties = arrayOf(AbstractIdWithUUID::id)
        private val toStringProperties = arrayOf(AbstractIdWithUUID::id)
    }

    override fun toString() = kotlinToString(properties = toStringProperties)
    override fun equals(other: Any?) = kotlinEquals(other = other, properties = equalsAndHashCodeProperties)
    override fun hashCode() = kotlinHashCode(properties = equalsAndHashCodeProperties)
}
