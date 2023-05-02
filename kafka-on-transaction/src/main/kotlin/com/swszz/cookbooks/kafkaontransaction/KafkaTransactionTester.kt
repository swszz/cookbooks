package com.swszz.cookbooks.kafkaontransaction

/**
 * 카프카 트랜잭션 테스트를 위한 인터페이스
 * @author: swszz
 */
interface KafkaTransactionTester {

    /**
     * @Impl 해당 기능은 아래와 같은 순서로 'Entity 저장 및 Kafka Message Publish'를 구현한다. 단, 실제 동작 순서는 동일하지 않아도 된다.
     * - 1. Entity를 생성한다.
     * - 2. Entiny를 저장한다.
     * - 3. Kafka Message를 publish 한다.
     */
    fun execute()
}