package com.swszz.kopring.beer.adapter.`in`.web.model

import com.swszz.kopring.beer.domain.Beer
import jakarta.annotation.Nonnull

/**
 * @author: swszz
 */
data class OrderRequest(@Nonnull val type: Beer.Type,
                        @Nonnull val size: Beer.Size,
                        val count: Int = 0,
                        val options: MutableSet<String> = mutableSetOf())