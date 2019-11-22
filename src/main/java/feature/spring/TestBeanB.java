package feature.spring;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2019/09/26
 */
@Component
public class TestBeanB implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass() + "afterPropertiesSet");
    }


    @PostConstruct
    public void init(){
        System.out.println(this.getClass() + "PostConstruct");
    }

}
