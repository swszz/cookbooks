package com.swszz.kopring.pub.adapter.`in`.web.model

import com.swszz.kopring.pub.domain.Order

/**
 * @author: swszz
 */
data class FindOrdersResponse(val orders: MutableList<Order>)