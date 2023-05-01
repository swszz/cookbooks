package com.swszz.kopring.pub.application

import com.swszz.kopring.pub.application.port.`in`.FindOrdersQuery
import com.swszz.kopring.pub.application.port.`in`.FindOrdersUseCase
import com.swszz.kopring.pub.application.port.out.LoadOrdersPort
import com.swszz.kopring.pub.application.port.out.LoadOrdersQuery
import org.springframework.stereotype.Service

/**
 * @author: swszz
 */
@Service
class QueryOrderService(val loadOrdersPort: LoadOrdersPort) : FindOrdersUseCase {
    override fun findOrders(findOrdersQuery: FindOrdersQuery): Int {
        print(findOrdersQuery)
        val query = findOrdersQuery.let {
            LoadOrdersQuery(it.type, it.status)
        }
        return loadOrdersPort.loadOrders(query)
    }
}