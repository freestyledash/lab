package main.java.feature.anno.mutiAnno;

import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 * @author zhangyanqi
 * @since 1.0 2020/3/8
 */
public class AnnoReader {

    public static void main(String[] args) {
        Annotation[] annotations = Sample.class.getAnnotations();
        String s = Arrays.toString(annotations);
        System.out.println(s);
    }
}
