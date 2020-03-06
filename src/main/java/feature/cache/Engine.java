package feature.cache;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Engine will find all method annotated by {@link Cache.Read},{@link Cache.Write} and weave cache aspect into those
 * methods
 *
 * aspect mainly duty is below:
 *
 * get Value from cache before invoke DAO:
 * aspect use {@link CacheRepository} to find the cached source.
 * if success,skip proxied function invoking.
 * if failed,retrieve data from exterior repository and then it save in {@link CacheRepository}
 *
 * update/delete value
 * delete cache
 *
 * warning:
 * Engine have a dependency on spring AOP and CGLIB,so,it can't proxy static method ,private method and other class or
 * method to witch that GCLIB can't access
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2020/03/06
 */

@Aspect
@Component
public class Engine {

    @Resource
    private CacheRepository repository;

    /**
     * find all method annotated by {@link Cache.ReadFromCacheFires}
     */
    @Around("@annotation(Cache.ReadFromCacheFires)")
    public Object readPointCut(ProceedingJoinPoint joinPoint) throws Exception {
        Object result = null;
        //todo
        //1. generate key
        String key = null;

        //2. use key to get object maybe cached in repository
        result = repository.get(key, Object.class);

        //3. if hit return key
        if (result != null) {
            return result;
        }

        //4. if miss invoke proxied method
        try {
            result = joinPoint.proceed();
            //write to cache
            //this could failed ,but it shouldn't stop the process
            try {
                repository.save(key, result);
            } catch (Exception e) {
                //ignore
            }
        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    /**
     * find all method annotated by {@link Cache.WriteToCacheLatter}
     */
    @Around(value = "@annotation(Cache.WriteToCacheLatter)")
    public Object writePointCut(ProceedingJoinPoint joinPoint) throws Exception {
        Object result = null;
        //todo
        //1. generate key
        String key = null;

        // 2.invoke origin method
        try {
            result = joinPoint.proceed();
            try {
                repository.delete(key);
            } catch (Exception e) {
                //ignore
                //should never happen
            }
        } catch (Exception e) {
            throw e;
        }
        return result;
    }

}
