package com.swszz.cookbooks.kafkaontransaction

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaOnTransactionApplication

fun main(args: Array<String>) {
	runApplication<KafkaOnTransactionApplication>(*args)
}
