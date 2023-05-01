package com.swszz.kopring.beer.adapter.`in`.web

import com.swszz.kopring.beer.adapter.`in`.web.model.OrderRequest
import com.swszz.kopring.beer.adapter.`in`.web.model.OrderResponse
import com.swszz.kopring.beer.application.port.`in`.OrderBeerCommand
import com.swszz.kopring.beer.application.port.`in`.OrderBeerUseCase
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

/**
 * @author: swszz
 */
@RestController
class OrderController(val orderBeerUseCase: OrderBeerUseCase) {

    @PostMapping("order/beer")
    fun order(@Validated @RequestBody orderRequest: OrderRequest): OrderResponse {
        println(orderRequest)
        val orderBeerCommand = orderRequest.let {
            println(it.options)
            OrderBeerCommand(it.type, it.size, it.count, it.options)
        }
        val completed: Boolean = orderBeerUseCase.order(orderBeerCommand)

        return OrderResponse(completed)
    }
}