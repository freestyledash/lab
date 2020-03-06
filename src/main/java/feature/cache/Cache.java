package feature.cache;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * contains Annotation that marks the Annotated method
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2020/03/06
 */
public class Cache {

    private Cache() {}

    @Inherited
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ReadFromCacheFires {

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

    @Inherited
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface WriteToCacheLatter {

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

}
