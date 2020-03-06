package feature.spring.recursiveRely;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

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
