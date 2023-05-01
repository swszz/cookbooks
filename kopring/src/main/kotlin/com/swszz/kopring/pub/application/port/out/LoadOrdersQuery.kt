package com.swszz.kopring.pub.application.port.out

import com.swszz.kopring.pub.domain.Order

/**
 * @author: swszz
 */
data class LoadOrdersQuery(val type: Order.Type, val status: Order.Status? = null)