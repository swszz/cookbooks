package com.swszz.cookbooks.dddwithhexagonal.payment.adapter.out.persistence

import com.swszz.cookbooks.dddwithhexagonal.payment.adapter.out.persistence.entity.Payments
import com.swszz.cookbooks.dddwithhexagonal.payment.adapter.out.persistence.entity.PaymentsJpaRepository
import com.swszz.cookbooks.dddwithhexagonal.payment.application.port.out.PaymentsStore
import com.swszz.cookbooks.dddwithhexagonal.payment.domain.model.Method
import com.swszz.cookbooks.dddwithhexagonal.payment.domain.model.Payment
import org.springframework.stereotype.Repository

/**
 * Spring Data Jpa를 사용하는 결제 도메인 스토어
 * @author: swszz
 */

@Repository
class SpringDataJpaPaymentsStore(private val paymentsJpaRepository: PaymentsJpaRepository) : PaymentsStore {

    // TODO: 어그리거트 루트에 대한 고도화 필요, 임의의 값만 제시... 동일 객체에 값을 스위칭해서 줘야 함...
    override fun insert(payment: Payment): Payment {
        val payments: Payments = paymentsJpaRepository.save(Payments())
        return Payment.of(Method.Type.CASH, 1000)
    }
}