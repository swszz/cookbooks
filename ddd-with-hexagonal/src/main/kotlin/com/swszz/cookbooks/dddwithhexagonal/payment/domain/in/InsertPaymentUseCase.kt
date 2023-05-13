package com.swszz.cookbooks.dddwithhexagonal.payment.domain.`in`

import com.swszz.cookbooks.dddwithhexagonal.payment.domain.model.Payment

/**
 * 결제 내역 저장 유즈케이스
 * @author: swszz
 */
interface InsertPaymentUseCase {
    fun insertPayment(insertPaymentCommand: InsertPaymentCommand): Payment
}