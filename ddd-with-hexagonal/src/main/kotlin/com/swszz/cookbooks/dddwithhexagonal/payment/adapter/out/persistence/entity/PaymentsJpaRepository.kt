package com.swszz.cookbooks.dddwithhexagonal.payment.adapter.out.persistence.entity

import com.swszz.cookbooks.dddwithhexagonal.common.entity.Id
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Aggregate Root Entity Repository for Payments
 * @author: swszz
 */
interface PaymentsJpaRepository : JpaRepository<Payments, Id>