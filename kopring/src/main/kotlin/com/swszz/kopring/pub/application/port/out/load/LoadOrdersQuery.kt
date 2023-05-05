package com.swszz.kopring.pub.application.port.out.load

import com.swszz.kopring.pub.domain.Order

/**
 * 주문 조회 전용 sealed 클래스
 * @author: swszz
 */
sealed class LoadOrdersQuery {
    companion object {
        fun create(key: String?, status: Order.Status? = Order.Status.NONE): LoadOrdersQuery {
            if (key != null) {
                return LoadOrderQueryWithKey(key)
            }
            if (status != null) {
                return LoadOrderQueryWithStatus(status)
            }

            return LoadOrderQueryWithDummy
        }
    }
}