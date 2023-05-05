package com.swszz.kopring.pub.application

import com.swszz.kopring.pub.application.port.`in`.FindOrdersQuery
import com.swszz.kopring.pub.application.port.`in`.FindOrdersUseCase
import com.swszz.kopring.pub.application.port.out.load.LoadOrdersPort
import com.swszz.kopring.pub.application.port.out.load.LoadOrdersQuery
import com.swszz.kopring.pub.domain.Order
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service

/**
 * @author: swszz
 */
@Service
class QueryOrderService(private val loadOrdersPort: LoadOrdersPort) : FindOrdersUseCase {
    override fun findOrders(findOrdersQuery: FindOrdersQuery): MutableList<Order> {
        return with(findOrdersQuery) {
            val query = LoadOrdersQuery.create(key, status)
            loadOrdersPort.loadOrders(query)
        }.ifEmpty { throw EntityNotFoundException() }
    }
}