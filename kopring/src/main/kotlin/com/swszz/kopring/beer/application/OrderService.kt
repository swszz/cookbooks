package com.swszz.kopring.beer.application

import com.swszz.kopring.beer.application.port.`in`.OrderCommand
import com.swszz.kopring.beer.application.port.`in`.OrderUseCase
import com.swszz.kopring.beer.application.port.out.SaveOrderCommand
import com.swszz.kopring.beer.application.port.out.SaveOrderPort
import org.springframework.stereotype.Service

/**
 * @author: swszz
 */
@Service
class OrderService(val saveOrderPort: SaveOrderPort) : OrderUseCase {
    override fun order(orderCommand: OrderCommand): Boolean {
        val saveOrderCommand = orderCommand.let {
            SaveOrderCommand(it.type, it.size, it.count)
        }
        return saveOrderPort.save(saveOrderCommand)
    }
}