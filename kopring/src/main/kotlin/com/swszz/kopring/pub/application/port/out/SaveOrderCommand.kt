package com.swszz.kopring.pub.application.port.out

import com.swszz.kopring.pub.domain.Beer

/**
 * @author: swszz
 */
data class SaveOrderCommand(val type: Beer.Type,
                            val size: Beer.Size,
                            val count: Int,
                            val options : MutableSet<String>)