package com.swszz.cookbooks.staticentityaccessor

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

/**
 * 테스트 데이터 생성
 * @author: swszz
 */

@Component
class ApplicationRunner(
    private val studentRepository: StudentRepository,
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        val students: List<Student> = listOf(Student(name = "sungwon"), Student(name = "jun"), Student(name = "taewoo"))
        studentRepository.saveAll(students)
    }
}