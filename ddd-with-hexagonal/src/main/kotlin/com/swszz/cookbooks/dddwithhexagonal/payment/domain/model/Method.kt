package com.swszz.cookbooks.dddwithhexagonal.payment.domain.model

/**
 * 결제 수단 도메인
 * @author: swszz
 */
abstract class Method {
    companion object {
        fun of(type: Type): Method {
            return when (type) {
                Type.CASH -> Cash()
                Type.CREDIT_CARD -> CreditCard()
            }
        }
    }

    enum class Type {
        CASH,
        CREDIT_CARD
    }
}