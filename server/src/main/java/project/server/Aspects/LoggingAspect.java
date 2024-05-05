package project.server.Aspects;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import org.apache.log4j.Logger;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class);

    @Pointcut("execution(* project.server.Controllers.*.*(..))")
    private void controllerMethods() {}


    
    @Pointcut("execution(* project.server.Services.*.*(..))")
    private void serviceMethods() {}

    @Pointcut("execution(* project.server.Repositories.*.*(..))")
    private void repositoryMethods() {}

    @AfterReturning(pointcut = "controllerMethods()", returning = "result")
    public void logControllerAfterReturning(JoinPoint joinPoint, Object result) {
        logMethod(joinPoint, result);
    }

    @AfterReturning(pointcut = "serviceMethods()", returning = "result")
    public void logServiceAfterReturning(JoinPoint joinPoint, Object result) {
        logMethod(joinPoint, result);
    }

    @AfterReturning(pointcut = "repositoryMethods()", returning = "result")
    public void logRepositoryAfterReturning(JoinPoint joinPoint, Object result) {
        logMethod(joinPoint, result);
    }

    
    private void logMethod(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        logger.info("Method " + className + "." + methodName + " returned: " + result);
    }
}
