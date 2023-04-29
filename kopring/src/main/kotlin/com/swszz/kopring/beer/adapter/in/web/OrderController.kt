package com.swszz.kopring.beer.adapter.`in`.web

import com.swszz.kopring.beer.adapter.`in`.web.model.OrderRequest
import com.swszz.kopring.beer.adapter.`in`.web.model.OrderResponse
import com.swszz.kopring.beer.application.port.`in`.OrderCommand
import com.swszz.kopring.beer.application.port.`in`.OrderUseCase
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

/**
 * @author: swszz
 */
@RestController
class OrderController(val orderUseCase: OrderUseCase) {

    @PostMapping("beer/order")
    fun order(@Validated @RequestBody orderRequest: OrderRequest): OrderResponse {
        println(orderRequest)
        val orderCommand = orderRequest.let {
            OrderCommand(it.type, it.size, it.count)
        }
        val completed: Boolean = orderUseCase.order(orderCommand)

        return OrderResponse(completed)
    }
}