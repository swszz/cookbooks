package com.swszz.cookbooks.dddwithhexagonal.payment.domain.`in`

import com.swszz.cookbooks.dddwithhexagonal.common.entity.Id

/**
 * 중복된 결제 내역 확인 쿼리
 * @author: swszz
 */
class CheckDuplicatedPaymentQuery
private constructor(val id: Id) {
    companion object {
        fun of(value: String): CheckDuplicatedPaymentQuery {
            return CheckDuplicatedPaymentQuery(Id.of(value))
        }
    }
}