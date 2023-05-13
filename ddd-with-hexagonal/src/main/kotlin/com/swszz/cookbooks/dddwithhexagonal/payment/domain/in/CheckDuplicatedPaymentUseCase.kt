package com.swszz.cookbooks.dddwithhexagonal.payment.domain.`in`

/**
 * 중복된 결제 내역 확인 유즈케이스
 * @author: swszz
 */
interface CheckDuplicatedPaymentUseCase {
    fun checkDuplicatedPayment(checkDuplicatedPaymentQuery: CheckDuplicatedPaymentQuery): Boolean
}