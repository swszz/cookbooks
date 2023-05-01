package com.swszz.kopring.beer.application

import com.swszz.kopring.beer.application.port.`in`.OrderBeerCommand
import com.swszz.kopring.beer.application.port.`in`.OrderBeerUseCase
import com.swszz.kopring.beer.application.port.out.SaveOrderCommand
import com.swszz.kopring.beer.application.port.out.SaveOrderPort
import org.springframework.stereotype.Service

/**
 * @author: swszz
 */
@Service
class OrderBeerService(val saveOrderPort: SaveOrderPort) : OrderBeerUseCase {
    override fun order(orderBeerCommand: OrderBeerCommand): Boolean {
        val saveOrderCommand = orderBeerCommand.let {
            SaveOrderCommand(it.type, it.size, it.count, it.options)
        }
        return saveOrderPort.save(saveOrderCommand)
    }
}