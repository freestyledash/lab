package feature.cache.demo;

import javax.annotation.Resource;

import feature.spring.boot.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Cache {

    @Resource
    CRUDDemo demo;

    @Test
    public void test() {
        System.out.println(demo.getValueFromDb(1));
        System.out.println(demo.getValueFromDb(1));
        System.out.println(demo.getValueFromDb(1));
        System.out.println(demo.getValueFromDb(1));
    }

}