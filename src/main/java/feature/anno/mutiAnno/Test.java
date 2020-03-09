package feature.anno.mutiAnno;

/**
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2019/10/29
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
//!
@Repeatable(Tests.class)
public @interface Test {
    String value();
}