package com.swszz.kopring.beer.adapter.out.persistence.entity

import com.swszz.utils.kotlinEquals
import com.swszz.utils.kotlinHashCode
import com.swszz.utils.kotlinToString
import jakarta.persistence.Embeddable

/**
 * @author: swszz
 */
@Embeddable
class CustomizedOptions(private val options: MutableSet<String>) {
    companion object {
        private val equalsAndHashCodeProperties = arrayOf(CustomizedOptions::options)
        private val toStringProperties = arrayOf(CustomizedOptions::options)
        fun of(options: MutableSet<String>): CustomizedOptions {
            return CustomizedOptions(options)
        }
    }

    override fun toString() = kotlinToString(properties = toStringProperties)
    override fun equals(other: Any?) = kotlinEquals(other = other, properties = equalsAndHashCodeProperties)
    override fun hashCode() = kotlinHashCode(properties = equalsAndHashCodeProperties)
}