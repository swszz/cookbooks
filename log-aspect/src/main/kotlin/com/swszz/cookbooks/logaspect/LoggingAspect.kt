package com.swszz.cookbooks.logaspect

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.aspectj.lang.reflect.MethodSignature
import org.slf4j.LoggerFactory
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestHeader


/**
 * 로그 작성을 위한 Aspect 선언
 * @author: swszz
 */
@Aspect
@Component
class LoggingAspect() {

    @Pointcut("execution(@LoggingTarget * *(..))")
    private fun loggingTargetPointcut() {
    }

    @Around("loggingTargetPointcut()")
    private fun logForLoggingTarget(joinPoint: ProceedingJoinPoint): Any? {

        // ignore any throwable
        runCatching {
            when (val signature = joinPoint.signature) {
                // metadata for method
                is MethodSignature -> {
                    val parameterAnnotations = signature.method.parameterAnnotations
                    val parameterNames = signature.method.parameters.map { it.name }
                    val parameterArguments = joinPoint.args
                    val message = StringBuilder()

                    message.append("{ ${signature.name} - ")

                    parameterNames.zip(parameterArguments) // Pair <ParameterName, ParameterValue> as params
                        .zip(parameterAnnotations)      // Pair <params, ParameterAnnotations>
                        .filter { (_, annotations) -> annotations.none { it in LOGGING_IGNORED_ANNOTATIONS } }
                        .forEach { (nameAndArguments, _) -> run { message.append("${nameAndArguments.first} : ${nameAndArguments.second},") } }

                    message.append(" }")
                    log.info(message.toString())
                }
            }
        }

        return joinPoint.proceed(joinPoint.args)
    }

    companion object {
        private val LOGGING_IGNORED_ANNOTATIONS = setOf(IgnoredLogging::class.java, RequestHeader::class)
        private val log = LoggerFactory.getLogger(this::class.java)
    }
}