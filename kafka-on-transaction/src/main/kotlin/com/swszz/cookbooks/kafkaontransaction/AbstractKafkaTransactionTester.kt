package com.swszz.cookbooks.kafkaontransaction

import org.springframework.kafka.core.KafkaTemplate

/**
 * 카프카 트랜잭션 테스트를 위한 추상 클래스
 * @author: swszz
 */
abstract class AbstractKafkaTransactionTester(open val someEntityRepository: SomeEntityRepository,
                                              open val kafkaTemplate: KafkaTemplate<String, String>) : KafkaTransactionTester {

    // 테스트를 위한 더미 토픽, 메시지
    protected val topic: String = "topic"
    protected val message: String = "message"
}