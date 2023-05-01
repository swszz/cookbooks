package com.swszz.kopring.pub.adapter.`in`.web

import com.swszz.kopring.pub.adapter.`in`.web.model.OrderBeerRequest
import com.swszz.kopring.pub.adapter.`in`.web.model.OrderBeerResponse
import com.swszz.kopring.pub.application.port.`in`.FindOrdersQuery
import com.swszz.kopring.pub.application.port.`in`.FindOrdersUseCase
import com.swszz.kopring.pub.application.port.`in`.OrderBeerCommand
import com.swszz.kopring.pub.application.port.`in`.OrderBeerUseCase
import com.swszz.kopring.pub.domain.Order
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

/**
 * @author: swszz
 */
@RestController
class OrderController(val orderBeerUseCase: OrderBeerUseCase, val findOrdersUseCase: FindOrdersUseCase) {

    @PostMapping("order/beer")
    fun order(@Validated @RequestBody orderBeerRequest: OrderBeerRequest): OrderBeerResponse {
        val orderBeerCommand = orderBeerRequest.let {
            println(it.options)
            OrderBeerCommand(it.type, it.size, it.count, it.options)
        }
        val completed: Boolean = orderBeerUseCase.order(orderBeerCommand)

        return OrderBeerResponse(completed)
    }

    // todo 구현체 고도화해야 함
    @GetMapping("orders")
    fun list(): Int {
        return findOrdersUseCase.findOrders(FindOrdersQuery(Order.Type.BEER, null))
    }
}