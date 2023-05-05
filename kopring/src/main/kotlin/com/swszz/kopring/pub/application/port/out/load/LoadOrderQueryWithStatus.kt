package com.swszz.kopring.pub.application.port.`out`.load

import com.swszz.kopring.pub.domain.Order

/**
 * 오직 주문 상태로 조회하는 쿼리
 * @author: swszz
 */
data class LoadOrderQueryWithStatus(
    val status: Order.Status,
) : LoadOrdersQuery()