package com.swszz.kopring.pub.domain

/**
 * 주문 도메인
 * @author: swszz
 */
class Order() {

    enum class Type {
        BEER
    }

    enum class Status {
        ORDERED,
        COOKED
    }
}