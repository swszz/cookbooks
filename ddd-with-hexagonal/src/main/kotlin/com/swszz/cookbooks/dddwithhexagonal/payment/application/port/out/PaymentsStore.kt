package com.swszz.cookbooks.dddwithhexagonal.payment.application.port.out

import com.swszz.cookbooks.dddwithhexagonal.payment.domain.model.Payment

/**
 * 결제 도메인 엔티티에 대한 CUD 인터페이스
 * @author: swszz
 */
interface PaymentsStore {
    fun insert(payment: Payment): Payment
}