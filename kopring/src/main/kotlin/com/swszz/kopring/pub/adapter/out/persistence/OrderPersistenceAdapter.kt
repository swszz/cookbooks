package com.swszz.kopring.pub.adapter.out.persistence

import com.swszz.kopring.pub.adapter.out.persistence.entity.CustomizedOptions
import com.swszz.kopring.pub.adapter.out.persistence.entity.Order
import com.swszz.kopring.pub.application.port.out.LoadOrdersPort
import com.swszz.kopring.pub.application.port.out.LoadOrdersQuery
import com.swszz.kopring.pub.application.port.out.SaveOrderCommand
import com.swszz.kopring.pub.application.port.out.SaveOrderPort
import org.springframework.stereotype.Component

/**
 * @author: swszz
 */
@Component
class OrderPersistenceAdapter(val orderRepository: OrderRepository) : SaveOrderPort, LoadOrdersPort {
    override fun save(saveOrderCommand: SaveOrderCommand): Boolean {
        val order = saveOrderCommand.let {
            val options = CustomizedOptions(it.options)
            Order(type = it.type, size = it.size, count = it.count, options = options)
        }
        orderRepository.save(order)
        return true
    }

    override fun loadOrders(loadOrdersQuery: LoadOrdersQuery): Int {
        val size = loadOrdersQuery.let {
            orderRepository.findAll().size
        }
        return size
    }
}