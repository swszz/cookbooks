package com.swszz.cookbooks.dddwithhexagonal.payment.application.port.`in`

/**
 * 결제 등록 유즈케이스
 * @author: swszz
 */
interface SavePaymentUseCase {
    fun savePayment(savePaymentCommand: SavePaymentCommand)
}