package com.swszz.cookbooks.kafkaontransaction.testcase

import com.swszz.cookbooks.kafkaontransaction.AbstractKafkaTransactionTester
import com.swszz.cookbooks.kafkaontransaction.SomeEntity
import com.swszz.cookbooks.kafkaontransaction.SomeEntityRepository
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

/**
 * 아무런 제약없이 하나의 트랜잭션으로 처리할 경우
 * @author: swszz
 */
@Component
class PlainKafkaTransactionTester(override val someEntityRepository: SomeEntityRepository,
                                  override val kafkaTemplate: KafkaTemplate<String, String>) :
        AbstractKafkaTransactionTester(someEntityRepository, kafkaTemplate) {
    @Transactional
    override fun execute() {
        // 1. 엔티티 생성 및 저장
        val entity = SomeEntity()
        someEntityRepository.save(entity)
        // 2. 메시지 발행
        kafkaTemplate.send(topic, message)
    }
}