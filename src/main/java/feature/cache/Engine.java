package feature.cache;

import javax.annotation.Resource;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Engine will find all method annotated by {@link Cache.Read},{@link Cache.Write} by AspectJ expression
 * and weave cache aspect into those methods
 *
 * aspect mainly duty is below:
 *
 * get Value from cache before invoke DAO:
 * aspect use {@link CacheRepository} to find the cached source.
 * if success,skip proxied function invoking.
 * if failed,retrieve data from exterior repository and save in {@link CacheRepository}
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
public class Engine {

    @Resource
    private CacheRepository repository;

    /**
     * find all method annotated by {@link Cache.Read}
     */
    @Around(value = "")
    public void readPointCut() {

    }

    /**
     * find all method annotated by {@link Cache.Write}
     */
    @Around(value = "")
    public void writePointCut() {

    }

}
