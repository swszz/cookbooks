package com.swszz.kopring.pub.adapter.out.persistence


import com.swszz.kopring.pub.adapter.out.persistence.entity.BeerOrder
import com.swszz.kopring.pub.adapter.out.persistence.entity.CustomizedOptions
import com.swszz.kopring.pub.application.port.out.CreateOrderPort
import com.swszz.kopring.pub.application.port.out.SaveOrderBeerCommand
import com.swszz.kopring.pub.application.port.out.SaveOrderBeerPort
import com.swszz.kopring.pub.application.port.out.load.*
import com.swszz.kopring.pub.domain.Beer
import com.swszz.kopring.pub.domain.Order
import org.springframework.stereotype.Component

/**
 * @author: swszz
 */
@Component
class OrderPersistenceAdapter(
    private val orderRepository: OrderRepository,
    private val beerOrderRepository: BeerOrderRepository,
) : CreateOrderPort, LoadOrdersPort, SaveOrderBeerPort {

    override fun loadOrders(loadOrdersQuery: LoadOrdersQuery): MutableList<Order> {
        return when (loadOrdersQuery) {
            is LoadOrderQueryWithKey -> mutableListOf(orderRepository.findByKeyEquals(loadOrdersQuery.key))
            is LoadOrderQueryWithStatus -> orderRepository.findAllByStatusEquals(loadOrdersQuery.status)
            is LoadOrderQueryWithDummy -> orderRepository.findAll()
        }.filterNotNull()
            .map { Order(it.getKey(), it.getStatus()) }
            .toMutableList()
    }

    override fun createOrder(): Order {
        return orderRepository.save(com.swszz.kopring.pub.adapter.out.persistence.entity.Order())
            .let { Order(it.getKey(), it.getStatus()) }
    }

    override fun save(saveOrderBeerCommand: SaveOrderBeerCommand): Beer {
        return with(saveOrderBeerCommand) {
            val options = CustomizedOptions(options)
            var beerOrder = BeerOrder(type, size, count, options)
            beerOrder = beerOrderRepository.save(beerOrder)
            Beer(beerOrder.getType(), beerOrder.getSize(), beerOrder.getCount(), beerOrder.getOptions().get())
        }
    }
}