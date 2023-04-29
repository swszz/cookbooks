package com.swszz.kopring.beer.application.port.out

/**
 * @author: swszz
 */
interface SaveOrderPort {
    fun save(saveOrderCommand: SaveOrderCommand): Boolean
}