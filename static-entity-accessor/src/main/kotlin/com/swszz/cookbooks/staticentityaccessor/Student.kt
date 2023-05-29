package com.swszz.cookbooks.staticentityaccessor

import jakarta.persistence.*

/**
 * @author: swszz
 */
@Entity
class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column
    var name: String,
)