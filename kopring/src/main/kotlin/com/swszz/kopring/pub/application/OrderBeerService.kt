package com.swszz.kopring.pub.application

import com.swszz.kopring.pub.application.port.`in`.OrderBeerCommand
import com.swszz.kopring.pub.application.port.`in`.OrderBeerUseCase
import com.swszz.kopring.pub.application.port.out.CreateOrderPort
import com.swszz.kopring.pub.application.port.out.SaveOrderBeerCommand
import com.swszz.kopring.pub.application.port.out.SaveOrderBeerPort
import com.swszz.kopring.pub.application.port.out.load.LoadOrdersPort
import com.swszz.kopring.pub.application.port.out.load.LoadOrdersQuery
import org.springframework.stereotype.Service

/**
 * @author: swszz
 */
@Service
class OrderBeerService(
    private val loadOrdersPort: LoadOrdersPort,
    private val createOrderPort: CreateOrderPort,
    private val saveOrderBeerPort: SaveOrderBeerPort,
) : OrderBeerUseCase {
    override fun orderBeer(orderBeerCommand: OrderBeerCommand): Boolean {
        with(orderBeerCommand) {
            val query = LoadOrdersQuery.create(key = orderKey)
            val orders = loadOrdersPort.loadOrders(query)
            val order = orders.firstOrNull() ?: createOrderPort.createOrder()
            val command = SaveOrderBeerCommand(type, size, order.key, count, options)
            saveOrderBeerPort.save(command)
        }
        return true
    }
}