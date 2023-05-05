package com.swszz.kopring.pub.application.port.out.load

/**
 * 오직 주문 키로 조회하는 쿼리
 * @author: swszz
 */
data class LoadOrderQueryWithKey(val key: String) : LoadOrdersQuery()