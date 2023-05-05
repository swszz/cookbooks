package com.swszz.kopring.pub.adapter.out.persistence.entity

import com.swszz.kopring.pub.domain.Beer
import com.swszz.utils.kotlinEquals
import com.swszz.utils.kotlinHashCode
import com.swszz.utils.kotlinToString
import io.hypersistence.utils.hibernate.type.json.JsonType
import jakarta.persistence.*
import org.hibernate.annotations.Comment
import org.hibernate.annotations.Type

/**
 * 맥주 주문 테이블
 * TODO() 인덱스, 주문 키 추가 필요
 * @author: swszz
 */
@Entity
class BeerOrder(
    @Enumerated(EnumType.STRING) @Column(updatable = false, nullable = false) private var type: Beer.Type,
    @Enumerated(EnumType.STRING) @Column(updatable = false, nullable = false) private var size: Beer.Size,
    @Column(updatable = false, nullable = false) private var count: Int,
    @Type(JsonType::class) @Column(
        updatable = true,
        nullable = false,
        columnDefinition = ColumnDefinitions.CLOB
    ) private var options: CustomizedOptions,
) : AbstractAuditingEntity() {

    @Comment("Primary Key")
    @Id
    @Column(updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null

    fun getType() = type
    fun getCount() = count
    fun getSize() = size
    fun getOptions() = options
    override fun toString() = kotlinToString(properties = toStringProperties, superToString = { super.toString() })
    override fun equals(other: Any?) = kotlinEquals(other = other, properties = equalsAndHashCodeProperties)
    override fun hashCode() = kotlinHashCode(properties = equalsAndHashCodeProperties)

    companion object {
        private val equalsAndHashCodeProperties = arrayOf(BeerOrder::id)
        private val toStringProperties = arrayOf(BeerOrder::type, BeerOrder::size, BeerOrder::count, BeerOrder::options)
    }
}