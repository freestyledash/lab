package main.java.feature.cache.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import main.java.feature.cache.KeyExtractor;

/**
 *
 */
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CleanCacheLatter {

    /**
     * 从第n个位置提取key
     *
     * @return
     */
    int index();

    /**
     * 前缀
     *
     * @return
     */
    String prefix();

    /**
     * 提取key
     *
     * @return
     */
    Class<? extends KeyExtractor> extractor();
}
