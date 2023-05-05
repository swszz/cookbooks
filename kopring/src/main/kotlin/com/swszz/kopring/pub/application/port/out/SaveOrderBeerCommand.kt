package com.swszz.kopring.pub.application.port.out

import com.swszz.kopring.pub.domain.Beer

/**
 * @author: swszz
 */
data class SaveOrderBeerCommand(
    val type: Beer.Type,
    val size: Beer.Size,
    val orderKey: String,
    val count: Int = 0,
    val options: MutableSet<String> = mutableSetOf(),
)