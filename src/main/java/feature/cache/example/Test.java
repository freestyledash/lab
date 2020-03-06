package feature.cache.example;

import feature.cache.Cache.ReadFromCacheFires;
import feature.cache.Cache.WriteToCacheLatter;
import feature.cache.KeyExtractor;
import org.springframework.stereotype.Component;

/**
 * Description
 * todo
 *
 * ImportantDependency
 * todo
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2020/03/06
 */
@Component
public class Test {

    @ReadFromCacheFires(index = 0, prefix = "test", extractor = E.class)
    public String getValueFromDb(Integer id) {
        return "";
    }

    @WriteToCacheLatter(index = 0, prefix = "test", extractor = E.class)
    public String update(Integer id) {
        return "";
    }

    static class E implements KeyExtractor<Integer> {
        @Override
        public String extract(Integer t) {
            return null;
        }
    }

}
