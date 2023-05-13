package com.swszz.cookbooks.dddwithhexagonal.payment.application.port.out

import com.swszz.cookbooks.dddwithhexagonal.common.entity.Id
import com.swszz.cookbooks.dddwithhexagonal.payment.domain.model.Payment

/**
 * 결제 도메인 엔티티에 대한 조회 인터페이스
 * @author: swszz
 */
interface PaymentsReader {
    fun findById(id: Id): Payment
    fun existById(id: Id): Boolean
}