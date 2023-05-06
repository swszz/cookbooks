package com.swszz.cookbooks.reactivefeign

import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author: swszz
 */

@EnableScheduling
@RestController
class HelloWorldCallerController(private val simpleReactiveFeignClient: SimpleReactiveFeignClient) {

    @GetMapping("call")
    fun callHelloWorld() {
        println(simpleReactiveFeignClient.helloWorld().block()!!)
        println(simpleReactiveFeignClient.helloWorldWithHeaders("sungwon").block()!!)
        println(simpleReactiveFeignClient.helloWorldWithPathVariables("sungwon").block()!!)
        println(simpleReactiveFeignClient.helloWorldWithQueryString("sungwon").block()!!)
        println(simpleReactiveFeignClient.helloWorldWithHeaderMap(mapOf(Pair("x-requester-id", "sungwon"))).block()!!)
        println(simpleReactiveFeignClient.helloWorldWithBody(HelloWorldRequest("sungwon")).block()!!)
    }
}