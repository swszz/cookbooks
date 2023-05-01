package com.swszz.kopring.pub.application.port.`in`

import com.swszz.kopring.pub.domain.Beer

/**
 * 맥주 주문 커멘드 for useCase
 * @author: swszz
 */
data class OrderBeerCommand(val type: Beer.Type,
                            val size: Beer.Size,
                            override val count: Int,
                            override val options: MutableSet<String>) : AbstractOrderCommand(count, options)
