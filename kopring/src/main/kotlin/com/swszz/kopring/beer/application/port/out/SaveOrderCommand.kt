package com.swszz.kopring.beer.application.port.out

import com.swszz.kopring.beer.domain.Beer

/**
 * @author: swszz
 */
data class SaveOrderCommand(private val type: Beer.Type, private val size: Beer.Size, private val count: Int)