package com.swszz.cookbooks.logaspect

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.aspectj.lang.reflect.MethodSignature
import org.springframework.stereotype.Component


/**
 * 로그 작성을 위한 Aspect 선언
 * @author: swszz
 */

@Aspect
@Component
class LoggingAspect {

    @Pointcut("execution(@LoggingTarget * *(..))")
    private fun loggingTargetPointcut() {
    }

    @Around("loggingTargetPointcut()")
    private fun logForLoggingTarget(joinPoint: ProceedingJoinPoint): Any? {

        val methodSignature: MethodSignature = joinPoint.signature as MethodSignature
        val parameterAnnotations = methodSignature.method.parameterAnnotations
        val parameterNames = methodSignature.method.parameters.map { it.name }
        val parameterValues = joinPoint.args

        // Pair <ParameterName, ParameterValue> & ParameterAnnotations
        parameterNames.zip(parameterValues).zip(parameterAnnotations)
            .filter { (_, annotations) -> annotations.none { it is IgnoredLogging } }
            .forEach { (nameAndValues, _) -> run { println(nameAndValues.second) } }

        return joinPoint.proceed(joinPoint.args)
    }
}
