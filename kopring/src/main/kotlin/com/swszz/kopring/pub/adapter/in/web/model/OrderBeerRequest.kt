package com.swszz.kopring.pub.adapter.`in`.web.model

import com.swszz.kopring.pub.domain.Beer
import jakarta.annotation.Nonnull

/**
 * @author: swszz
 */
data class OrderBeerRequest(@Nonnull val type: Beer.Type,
                            @Nonnull val size: Beer.Size,
                            val count: Int = 0,
                            val options: MutableSet<String> = mutableSetOf())