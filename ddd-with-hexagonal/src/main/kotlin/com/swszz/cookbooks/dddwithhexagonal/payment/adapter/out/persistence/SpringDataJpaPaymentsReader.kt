package com.swszz.cookbooks.dddwithhexagonal.payment.adapter.out.persistence

import com.swszz.cookbooks.dddwithhexagonal.common.entity.Id
import com.swszz.cookbooks.dddwithhexagonal.payment.adapter.out.persistence.entity.PaymentsJpaRepository
import com.swszz.cookbooks.dddwithhexagonal.payment.application.port.out.PaymentsReader
import com.swszz.cookbooks.dddwithhexagonal.payment.domain.model.Method
import com.swszz.cookbooks.dddwithhexagonal.payment.domain.model.Payment
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Repository

/**
 * Spring Data Jpa를 사용하는 Payments Reader
 * @author: swszz
 */
@Repository
class SpringDataJpaPaymentsReader(private val paymentsJpaRepository: PaymentsJpaRepository) :
    PaymentsReader {

    // TODO: 추후 고도화해야 함
    override fun findById(id: Id): Payment {
        val entity = paymentsJpaRepository.findById(id).orElseThrow(::EntityNotFoundException)
        return Payment.of(Method.Type.CASH, 1000)
    }

    override fun existById(id: Id): Boolean {
        return false
    }
}