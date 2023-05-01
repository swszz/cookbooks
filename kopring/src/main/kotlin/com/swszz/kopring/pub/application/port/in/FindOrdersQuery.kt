package com.swszz.kopring.pub.application.port.`in`

import com.swszz.kopring.pub.domain.Order

/**
 * 주문 목록 조회 요청
 * @author: swszz
 */
data class FindOrdersQuery(val type: Order.Type, val status: Order.Status? = null)