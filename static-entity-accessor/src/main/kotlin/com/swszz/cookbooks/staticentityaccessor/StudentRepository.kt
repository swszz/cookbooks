package com.swszz.cookbooks.staticentityaccessor

import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author: swszz
 */
interface StudentRepository : JpaRepository<Student, Long>