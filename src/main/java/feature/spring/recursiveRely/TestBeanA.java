package feature.spring.recursiveRely;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
//import javax.annotation.Resource;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
//import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
//import org.springframework.stereotype.Component;

/**
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2019/09/25
 */
@Component
public class TestBeanA {

    @Resource
    private TestBeanB testBeanB;

    public TestBeanA(TestBeanB b) {
        this.testBeanB = b;
    }


}
