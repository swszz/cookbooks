package com.swszz.cookbooks.dddwithhexagonal.payment.domain.model

import com.swszz.cookbooks.dddwithhexagonal.common.functions.isPositive
import org.springframework.util.Assert
import java.math.BigDecimal


/**
 * 금액을 다루는 도메인 모델
 * @author: swszz
 */
class Amount
private constructor(private val value: BigDecimal) {
    companion object {
        fun of(value: Long): Amount {
            Assert.isTrue(value.isPositive(), "not allowed negative value")
            return Amount(BigDecimal.valueOf(value))
        }
    }
}