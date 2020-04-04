package feature.spring.proxy;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
public class TestImpl implements TestInterface {

    @Override
    public String dosth(Integer a) {
        return "a is " + a;
    }
}
