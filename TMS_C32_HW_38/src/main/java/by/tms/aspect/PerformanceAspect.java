package by.tms.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

    private static final Logger logger = LoggerFactory.getLogger(PerformanceAspect.class);

    @Pointcut("@annotation(com.by.tms.aspect.PerformanceLog)")
    public void methodsToProfile() {}

    @Around("methodsToProfile()")
    public Object profile(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        long duration = end - start;

        if (duration > 1000) { // 1 секунда = 1000 миллисекунд
            logger.warn("Метод {} выполнился за {} мс", joinPoint.getSignature().toShortString(), duration);
        } else {
            logger.debug("Метод {} выполнился за {} мс", joinPoint.getSignature().toShortString(), duration);
        }

        return result;
    }
}