package com.swszz.cookbooks.reactivefeign

import org.springframework.web.bind.annotation.*

/**
 * @author: swszz
 */

@RestController
class HelloWorldController {
    @GetMapping("hello-world")
    fun helloWorldWithQueryString(
        @RequestHeader("x-requester-id", required = false) id: String?,
        @RequestParam("name", required = false) name: String?,
    ): String {
        return "x-requester-id = {$id}, name = {$name}"
    }

    @GetMapping("hello-world/{name}")
    fun helloWorldWithPathVariables(
        @RequestHeader("x-requester-id", required = false) id: String?,
        @PathVariable("name", required = false) name: String?,
    ): String {
        return "x-requester-id = {$id}, name = {$name}"
    }

    @PostMapping("hello-world")
    fun helloWorld(@RequestBody helloWorldRequest: HelloWorldRequest): String {
        return "name = {${helloWorldRequest.name}}"
    }
}