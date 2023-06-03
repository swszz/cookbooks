package com.swszz.cookbooks.meeting.infrastructure.jpa

import com.swszz.cookbooks.meeting.infrastructure.entity.Opening
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author: swszz
 */
interface OpeningJpaRepository : JpaRepository<Opening, Long>