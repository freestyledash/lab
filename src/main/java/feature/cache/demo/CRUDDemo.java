package feature.cache.demo;

import feature.cache.KeyExtractor;
import feature.cache.anno.CleanCacheLatter;
import feature.cache.anno.ReadFromCacheFires;
import org.springframework.stereotype.Component;

/**
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2020/03/06
 */

@Component
public class CRUDDemo {

    @ReadFromCacheFires(index = 0, prefix = "test", extractor = E.class)
    public String getValueFromDb(Integer id) {
        System.out.println("走耗时的DB拿数据");
        return "数据来了";
    }

    //存入/更新/ 会让对应的key失效
    @CleanCacheLatter(index = 0, prefix = "test", extractor = E.class)
    public String save(Integer id) {
        return "saveed";
    }

    public static class E implements KeyExtractor<Integer> {
        @Override
        public String extract(Integer t) {
            return t.toString();
        }
    }

}
