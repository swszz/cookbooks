package com.swszz.cookbooks.tunejpaquery

import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author: swszz
 */
interface MemberRepository : JpaRepository<Member, Long>