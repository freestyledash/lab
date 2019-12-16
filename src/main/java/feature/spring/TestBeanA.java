//package feature.spring;
//
//import javax.annotation.PostConstruct;
////import javax.annotation.Resource;
////
////import org.springframework.beans.BeansException;
////import org.springframework.beans.factory.InitializingBean;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
////import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
////import org.springframework.stereotype.Component;
//
///**
// * @author xiaoqi.zyq@alibaba-inc.com
// * @date 2019/09/25
// */
//@Component
//public class TestBeanA implements  InitializingBean {
//
//    //private final TestBeanB testBeanB;
//
//    //public TestBeanA(TestBeanB testBeanB) {this.testBeanB = testBeanB;}
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println(this.getClass() + "afterPropertiesSet");
//    }
//
//    @PostConstruct
//    public void init(){
//        System.out.println(this.getClass() + "PostConstruct");
//    }
//    //
//    //@Override
//    //public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory)
//    //    throws BeansException {
//    //    System.out.println("==========================");
//    //    System.out.println(this.getClass().getName());
//    //    System.out.println(hashCode());
//    //    System.out.println("==========================");
//    //}
//
//}
