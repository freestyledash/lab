package feature.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * springboot
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2020/03/05
 */
@SpringBootApplication
//@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(value = "feature.*")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
