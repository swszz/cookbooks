package com.swszz.cookbooks.logaspect

/**
 * 로깅하지 않을 파라메터 선언 어노테이션
 * @author: swszz
 */

@Target(AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class IgnoredLogging
