package com.swszz.cookbooks.dddwithhexagonal.payment.adapter.`in`.web

import com.swszz.cookbooks.dddwithhexagonal.payment.application.port.`in`.SavePaymentCommand
import com.swszz.cookbooks.dddwithhexagonal.payment.application.port.`in`.SavePaymentUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 결제 요청 수신 전용 컨트롤러
 * @author: swszz
 */

@RestController
class SavePaymentController(private val savePaymentUseCase: SavePaymentUseCase) {
    @PostMapping("payment")
    fun savePayment() {
        savePaymentUseCase.savePayment(SavePaymentCommand())
    }
}