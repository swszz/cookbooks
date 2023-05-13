package com.swszz.cookbooks.dddwithhexagonal.common.functions

/**
 * 숫자 자료형에 대한 확장 함수
 * @author: swszz
 */

fun Long.isPositive(): Boolean {
    return this >= 0
}

fun Long.isNegative(): Boolean {
    return !this.isPositive()
}