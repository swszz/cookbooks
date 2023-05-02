package com.swszz.cookbooks.kafkaontransaction

import org.springframework.data.jpa.repository.JpaRepository

/**
 * 테스트 엔티티 레파지토리
 * @author: swszz
 */
interface SomeEntityRepository : JpaRepository<SomeEntity, Long>