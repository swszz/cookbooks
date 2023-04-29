package com.swszz.kopring.beer.application.port.`in`

import com.swszz.kopring.beer.domain.Beer

/**
 * 맥주 주문 커멘드 for useCase
 * @author: swszz
 */
data class OrderCommand(val type: Beer.Type, val size: Beer.Size, val count: Int)