package com.swszz.cookbooks.kafkaontransaction

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author: swszz
 */
@RestController
class UnitTestController(val kafkaTemplate: KafkaTemplate<String, String>) {

    @GetMapping("test")
    fun test(){
        kafkaTemplate.send("topic", "message")
        println("123")
    }
}