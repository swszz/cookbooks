package com.swszz.cookbooks.reactivefeign

import feign.Headers
import feign.RequestLine
import org.springframework.web.bind.annotation.*
import reactivefeign.spring.config.ReactiveFeignClient
import reactor.core.publisher.Mono


/**
 * @author: swszz
 */

@Headers("Accept: application/json")
@ReactiveFeignClient(name = "simpleReactiveFeignClient", url = "http://localhost:8080")
interface SimpleReactiveFeignClient {
    @GetMapping("/hello-world")
    fun helloWorld(): Mono<String>

    @GetMapping("/hello-world")
    fun helloWorldWithHeaders(@RequestHeader(value = "x-requester-id") xRequesterId: String): Mono<String>

    @GetMapping("/hello-world")
    fun helloWorldWithHeaderMap(@RequestHeader map: Map<String, Any>): Mono<String>

    @GetMapping("/hello-world")
    fun helloWorldWithQueryString(@RequestParam name: String): Mono<String>

    @PostMapping("/hello-world")
    fun helloWorldWithBody(@RequestBody request: HelloWorldRequest): Mono<String>

    @GetMapping("/hello-world/{name}")
    @RequestLine("GET /hello-world/{name}")
    fun helloWorldWithPathVariables(@PathVariable name: String): Mono<String>

}