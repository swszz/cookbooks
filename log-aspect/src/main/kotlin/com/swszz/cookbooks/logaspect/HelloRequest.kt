package com.swszz.cookbooks.logaspect

import org.springframework.lang.NonNull

/**
 * @author: swszz
 */
data class HelloRequest(
    @NonNull val name: String?,
)