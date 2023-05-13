package com.swszz.cookbooks.dddwithhexagonal.payment.adapter.out.persistence.entity

import com.swszz.cookbooks.dddwithhexagonal.common.entity.AbstractAuditingEntity
import com.swszz.cookbooks.dddwithhexagonal.common.entity.Id
import jakarta.persistence.Column
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import kotlinEquals
import kotlinHashCode
import kotlinToString
import org.hibernate.annotations.Comment

/**
 * Payments Entity
 * @author: swszz
 */

@Entity
class Payments : AbstractAuditingEntity() {

    @EmbeddedId
    @Column(insertable = false, updatable = false)
    private var id: Id? = null

    // TODO: 추후 주문 도메인과 연결 필요, 우선 현재는 nullable 하게 냅둔다.
    @Comment("주문 ID")
    @Column(updatable = false, nullable = true)
    private var orderId: String? = null

    override fun toString() = kotlinToString(properties = toStringProperties, superToString = { super.toString() })
    override fun equals(other: Any?) = kotlinEquals(other = other, properties = equalsAndHashCodeProperties)
            && super.equals(other)

    override fun hashCode() = kotlinHashCode(properties = equalsAndHashCodeProperties)

    companion object {
        private val equalsAndHashCodeProperties = arrayOf(Payments::orderId)
        private val toStringProperties = arrayOf(Payments::orderId)
    }
}