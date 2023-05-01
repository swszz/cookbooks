package com.swszz.kopring.pub.application.port.out

/**
 * @author: swszz
 */
interface SaveOrderPort {
    fun save(saveOrderCommand: SaveOrderCommand): Boolean
}