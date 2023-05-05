package com.swszz.kopring.pub.application.port.out

import com.swszz.kopring.pub.domain.Beer

/**
 * @author: swszz
 */
interface SaveOrderBeerPort {
    fun save(saveOrderBeerCommand: SaveOrderBeerCommand): Beer
}