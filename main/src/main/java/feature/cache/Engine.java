package main.java.feature.cache;

import java.lang.reflect.Method;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;

import main.java.feature.cache.anno.CleanCacheLatter;
import main.java.feature.cache.anno.ReadFromCacheFires;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * Engine will find all method annotated by {@link ReadFromCacheFires},{@link CleanCacheLatter} and weave cache aspect
 * into those
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
     * find all method annotated by {@link ReadFromCacheFires}
     */
    @Around("@annotation(main.java.feature.cache.anno.ReadFromCacheFires)")
    public Object readPointCut(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        String key = null;
        //1. generate key
        try {
            key = generateKeyFromReadFromCacheFires(joinPoint);
        } catch (Exception e) {
            throw new RuntimeException("生成KEY失败");
        }

        //2. use key to get object maybe cached in repository
        String resultJson = repository.get(key);
        if (resultJson != null) {
            try {
                DataWarp dataWarp = JSON.parseObject(resultJson, DataWarp.class);
                return dataWarp.data;
            } catch (Exception e) {
                throw e;
            }
        }

        //3. if miss invoke proxied method
        try {
            result = joinPoint.proceed();
            //this could failed ,but it shouldn't stop the process
            try {
                DataWarp dataWarp = new DataWarp();
                dataWarp.data = result;
                String s = JSON.toJSONString(dataWarp);
                repository.save(key, s);
            } catch (Exception e) {
                //ignore
            }
        } catch (Throwable e) {
            throw e;
        }
        return result;
    }

    /**
     * find all method annotated by {@link CleanCacheLatter}
     */
    @Around(value = "@annotation(main.java.feature.cache.anno.CleanCacheLatter)")
    public Object writePointCut(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        String key = null;
        //1. generate key
        try {
            key = generateKeyFromCleanCacheLatter(joinPoint);
        } catch (Exception e) {
            throw new RuntimeException("生成KEY失败");
        }

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

    /**
     * 生成缓存key
     *
     * @param joinPoint
     * @return
     * @throws Exception
     */
    private String generateKeyFromReadFromCacheFires(ProceedingJoinPoint joinPoint) throws Exception {
        MethodSignature methodSignature = (MethodSignature)joinPoint.getStaticPart().getSignature();
        Method method = methodSignature.getMethod();
        ReadFromCacheFires annotation = method.getAnnotation(ReadFromCacheFires.class);
        Class<? extends KeyExtractor> extractor = annotation.extractor();
        KeyExtractor keyExtractor = extractor.newInstance();
        Object[] args = joinPoint.getArgs();
        int index = annotation.index();
        String prefix = annotation.prefix();
        String key = prefix + "-" + keyExtractor.extract(args[index]);
        return key;
    }

    private String generateKeyFromCleanCacheLatter(ProceedingJoinPoint joinPoint) throws Exception {
        MethodSignature methodSignature = (MethodSignature)joinPoint.getStaticPart().getSignature();
        Method method = methodSignature.getMethod();
        CleanCacheLatter annotation = method.getAnnotation(CleanCacheLatter.class);
        Class<? extends KeyExtractor> extractor = annotation.extractor();
        KeyExtractor keyExtractor = extractor.newInstance();
        Object[] args = joinPoint.getArgs();
        int index = annotation.index();
        String prefix = annotation.prefix();
        String key = prefix + "-" + keyExtractor.extract(args[index]);
        return key;
    }

    private static class DataWarp {
        private Object data;

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }
}
