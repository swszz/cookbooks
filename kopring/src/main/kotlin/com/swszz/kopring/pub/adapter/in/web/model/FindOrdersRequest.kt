package com.swszz.kopring.pub.adapter.`in`.web.model

import com.swszz.kopring.pub.domain.Order

/**
 * @author: swszz
 */
data class FindOrdersRequest(val key: String?, val status: Order.Status?)