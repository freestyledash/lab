package main.java.feature.time;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * java 常用时间API
 *
 * @author zhangyanqi
 * @since 1.0 2019-02-20
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME));
    }
}
