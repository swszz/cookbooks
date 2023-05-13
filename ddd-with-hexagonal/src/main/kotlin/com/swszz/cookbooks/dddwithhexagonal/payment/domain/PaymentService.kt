package com.swszz.cookbooks.dddwithhexagonal.payment.domain

import com.swszz.cookbooks.dddwithhexagonal.payment.application.port.out.PaymentsReader
import com.swszz.cookbooks.dddwithhexagonal.payment.application.port.out.PaymentsStore
import com.swszz.cookbooks.dddwithhexagonal.payment.domain.`in`.CheckDuplicatedPaymentQuery
import com.swszz.cookbooks.dddwithhexagonal.payment.domain.`in`.CheckDuplicatedPaymentUseCase
import com.swszz.cookbooks.dddwithhexagonal.payment.domain.`in`.InsertPaymentCommand
import com.swszz.cookbooks.dddwithhexagonal.payment.domain.`in`.InsertPaymentUseCase
import com.swszz.cookbooks.dddwithhexagonal.payment.domain.model.Method
import com.swszz.cookbooks.dddwithhexagonal.payment.domain.model.Payment
import org.springframework.stereotype.Service

/**
 * 결제 도메인 서비스
 * @author: swszz
 */
@Service
class PaymentService(
    private val paymentsReader: PaymentsReader,
    private val paymentsStore: PaymentsStore,
) : CheckDuplicatedPaymentUseCase, InsertPaymentUseCase {
    override fun checkDuplicatedPayment(checkDuplicatedPaymentQuery: CheckDuplicatedPaymentQuery): Boolean {
        return paymentsReader.existById(checkDuplicatedPaymentQuery.id)
    }

    override fun insertPayment(insertPaymentCommand: InsertPaymentCommand): Payment {
        return paymentsStore.insert(Payment.of(Method.Type.CASH, 1000))
    }
}