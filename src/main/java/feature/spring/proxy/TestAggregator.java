package feature.spring.proxy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Description
 * todo
 * <p>
 * ImportantDependency
 * todo
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2020/04/04
 */

@Component
public class TestAggregator implements ApplicationContextAware {

    @Resource
    private TestInterface testInterface;

    @Resource
    private TestImpl test;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("===Interface===");
        System.out.println(testInterface.getClass());
        System.out.println("===implements===");
        System.out.println(test.getClass());
        System.out.println(test.dosth(1));
    }
}
