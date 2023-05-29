package com.swszz.cookbooks.staticentityaccessor

import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component

/**
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