package com.swszz.cookbooks.logaspect

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

/**
 * @author: swszz
 */


@RestController
class HelloController {
    @LoggingTarget
    @GetMapping("hello/{name}/{temp}")
    fun hello(@PathVariable name: String, @IgnoredLogging @PathVariable temp: String) {
        println("hello world")
    }
}