package lab;

import javax.annotation.Resource;

import feature.spring.SpringMain;
import feature.spring.TestBeanA;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2019/09/25
 */
@RunWith(SpringRunner.class)      //its a junit runner,method will run in it
@SpringBootTest(classes = {SpringMain.class}) //for integration test
public class HaveATest {

    @Resource
    TestBeanA testBean;

    @Test
    public void test() {
        System.out.println(testBean.hashCode());
    }

}
