package com.swszz.kopring.pub.adapter.`in`.web

import com.swszz.kopring.pub.adapter.`in`.web.model.FindOrdersRequest
import com.swszz.kopring.pub.adapter.`in`.web.model.FindOrdersResponse
import com.swszz.kopring.pub.adapter.`in`.web.model.OrderBeerRequest
import com.swszz.kopring.pub.adapter.`in`.web.model.OrderBeerResponse
import com.swszz.kopring.pub.application.port.`in`.FindOrdersQuery
import com.swszz.kopring.pub.application.port.`in`.FindOrdersUseCase
import com.swszz.kopring.pub.application.port.`in`.OrderBeerCommand
import com.swszz.kopring.pub.application.port.`in`.OrderBeerUseCase
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

/**
 * @author: swszz
 */
@RestController
class OrderController(
    private val findOrdersUseCase: FindOrdersUseCase,
    private val orderBeerUseCase: OrderBeerUseCase,
) {

    @PostMapping("order/beer")
    fun orderBeer(@Validated @RequestBody orderBeerRequest: OrderBeerRequest): OrderBeerResponse {
        return with(orderBeerRequest) {
            val command =
                OrderBeerCommand(type = type, size = size, orderKey = orderKey, count = count, options = options)
            val ordered = orderBeerUseCase.orderBeer(command)
            OrderBeerResponse(ordered)
        }
    }

    @GetMapping("orders")
    fun findOrders(@RequestBody findOrdersRequest: FindOrdersRequest): FindOrdersResponse {
        return with(findOrdersRequest) {
            val query = FindOrdersQuery(key, status)
            val orders = findOrdersUseCase.findOrders(query)
            FindOrdersResponse(orders)
        }
    }
}