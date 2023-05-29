package com.swszz.cookbooks.staticentityaccessor

import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component

/**
 * ApplicationContextAware를 상속 받아, 별도 의존성 주입 없이 어플리케이션 어디서나 데이터를 참조할 수 있는 클래스
 * @author: swszz
 */

@Component
class StaticEntityAccessor : ApplicationContextAware {

    companion object {
        private lateinit var applicationContext: ApplicationContext
        fun setApplicationContextForLateInit(context: ApplicationContext) {
            applicationContext = context
        }

        fun findAllStudent(): List<Student> {
            val studentRepository = applicationContext.getBean(StudentRepository::class.java)
            return studentRepository.findAll()
        }
    }

    override fun setApplicationContext(context: ApplicationContext) {
        setApplicationContextForLateInit(context)
    }
}