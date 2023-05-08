package com.swszz.cookbooks.logaspect

/**
 * 로깅 대상 메소드 설정 어노테이션
 * @author: swszz
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class LoggingTarget()
