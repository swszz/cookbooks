package com.swszz.cookbooks.tunejpaquery

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author: swszz
 */

@RestController
class HelloController(private val helloService: HelloService) {

    @GetMapping("create")
    fun create() {
        helloService.create()
    }

    @GetMapping("remove")
    fun remove() {
        helloService.remove()
    }

}