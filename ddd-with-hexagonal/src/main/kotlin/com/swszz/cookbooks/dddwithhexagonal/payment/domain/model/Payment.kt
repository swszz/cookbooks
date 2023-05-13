package com.swszz.cookbooks.dddwithhexagonal.payment.domain.model


/**
 * 결제 도메인을 총괄하는 Aggregate Root
 * @author: swszz
 */
class Payment
private constructor(private val method: Method, private val amount: Amount) {
    companion object {
        fun of(type: Method.Type, value: Long): Payment {
            return Payment(Method.of(type), Amount.of(value))
        }
    }
}