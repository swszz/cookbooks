package com.swszz.kopring.beer.adapter.out.persistence.entity

import com.swszz.kopring.beer.domain.Beer
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
            Index(name = "unq_key", columnList = "key", unique = true),
            Index(name = "idx_type", columnList = "type", unique = false)
        ]
)
@EntityListeners(OrderEntityListener::class)
class Order(
        @Enumerated(EnumType.STRING)
        @Column(updatable = false, nullable = false)
        private var type: Beer.Type,
        @Enumerated(EnumType.STRING)
        @Column(updatable = false, nullable = false)
        private var size: Beer.Size,
        @Column(updatable = false, nullable = false)
        private var count: Int

) : AbstractAuditingEntity() {
    @Comment("Primary Key")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null

    @Comment("주문 고유 키")
    @Column(updatable = false, nullable = false)
    private var key: String? = null
}