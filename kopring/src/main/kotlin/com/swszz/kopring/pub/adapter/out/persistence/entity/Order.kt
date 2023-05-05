package com.swszz.kopring.pub.adapter.out.persistence.entity

import com.swszz.utils.kotlinEquals
import com.swszz.utils.kotlinHashCode
import com.swszz.utils.kotlinToString
import jakarta.persistence.*
import org.hibernate.annotations.Comment

/**
 * 주문 Entity
 * Hibernate 는 final class 에 대한 lazy loading 을 위한 proxy 를 생성할 수 없다. <p>
 * Kotlin 에서 모든 클래스는 final class 로 정의되기 때문에, open 예약어를 사용해야 한다. <p>
 * - field 또한 마찬가지다.
 * 또는 allOpen 플러그인을 활용하는 것도 방법이다.
 * @author: swszz
 */
@Entity
@Table(
    indexes = [
        Index(name = "unq_key", columnList = "key", unique = true)
    ]
)
@EntityListeners(OrderEntityListener::class)
class Order : AbstractAuditingEntity() {
    @Comment("Primary Key")
    @Id
    @Column(updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null

    @Comment("주문 고유 키")
    @Column(updatable = false, nullable = false)
    private var key: String? = null

    @Comment("주문 고유 키")
    @Enumerated(EnumType.STRING)
    @Column(updatable = false, nullable = false)
    private var status: com.swszz.kopring.pub.domain.Order.Status? = com.swszz.kopring.pub.domain.Order.Status.NONE

    /**
     * public getter 를 사용할 땐, entity가 조회된 후 호출하는 것을 명심
     */
    fun getId() = id!!
    fun getKey() = key!!
    fun getStatus() = status!!

    override fun toString() = kotlinToString(properties = toStringProperties, superToString = { super.toString() })
    override fun equals(other: Any?) = kotlinEquals(other = other, properties = equalsAndHashCodeProperties)
    override fun hashCode() = kotlinHashCode(properties = equalsAndHashCodeProperties)

    companion object {
        private val equalsAndHashCodeProperties = arrayOf(Order::id)
        private val toStringProperties = arrayOf(Order::id, Order::key)
    }
}