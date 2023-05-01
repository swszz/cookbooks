package com.swszz.kopring.pub.application.port.`in`

/**
 * 주문에 대한 커스텀 기록
 * @author: swszz
 */
interface Customizable {
    /**
     * @Impl 주문에 대한 커스텀을 기록한다.
     */

    fun customize(option: String)
}