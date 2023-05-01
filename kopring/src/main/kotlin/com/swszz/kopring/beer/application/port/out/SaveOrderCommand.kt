package com.swszz.kopring.beer.application.port.out

import com.swszz.kopring.beer.domain.Beer

/**
 * @author: swszz
 */
data class SaveOrderCommand(val type: Beer.Type,
                            val size: Beer.Size,
                            val count: Int,
                            val options : MutableSet<String>)