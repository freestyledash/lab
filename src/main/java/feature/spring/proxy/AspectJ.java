package feature.spring.proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Description
 * todo
 * <p>
 * ImportantDependency
 * todo
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2020/04/04
 */

@Aspect
//@Component
public class AspectJ {

    @Around("execution(public * feature.spring.proxy.TestInterface.*(..))")
    public Object logAroundAllOpenSerivePublicMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            System.out.println("代理");
            Object result = joinPoint.proceed();
            return result;
        } catch (Throwable e) {
            throw e;
        }
    }

}
