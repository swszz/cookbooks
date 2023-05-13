package com.swszz.cookbooks.dddwithhexagonal.payment.application

import com.swszz.cookbooks.dddwithhexagonal.payment.application.port.`in`.SavePaymentCommand
import com.swszz.cookbooks.dddwithhexagonal.payment.application.port.`in`.SavePaymentUseCase
import com.swszz.cookbooks.dddwithhexagonal.payment.domain.`in`.CheckDuplicatedPaymentQuery
import com.swszz.cookbooks.dddwithhexagonal.payment.domain.`in`.CheckDuplicatedPaymentUseCase
import com.swszz.cookbooks.dddwithhexagonal.payment.domain.`in`.InsertPaymentCommand
import com.swszz.cookbooks.dddwithhexagonal.payment.domain.`in`.InsertPaymentUseCase
import org.springframework.stereotype.Service
import java.util.*

/**
 * 결제 관련 어플리케이션 서비스
 * @author: swszz
 */
@Service
class PaymentApplicationService(
    private val checkDuplicatedPaymentUseCase: CheckDuplicatedPaymentUseCase,
    private val insertPaymentUseCase: InsertPaymentUseCase,
) : SavePaymentUseCase {
    override fun savePayment(savePaymentCommand: SavePaymentCommand) {
        if (!checkDuplicatedPaymentUseCase.checkDuplicatedPayment(
                CheckDuplicatedPaymentQuery.of(
                    UUID.randomUUID().toString()
                )
            )
        ) {
            insertPaymentUseCase.insertPayment(InsertPaymentCommand())
        }
    }
}