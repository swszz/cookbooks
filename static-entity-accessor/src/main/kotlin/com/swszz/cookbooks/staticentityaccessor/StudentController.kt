package com.swszz.cookbooks.staticentityaccessor

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author: swszz
 */


@RestController
@RequestMapping("student")
class StudentController {
    @GetMapping
    fun findAllStudentNames(): List<String> {
        return StaticEntityAccessor.findAllStudent().map { it.name }
    }
}