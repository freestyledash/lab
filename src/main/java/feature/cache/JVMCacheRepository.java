package feature.cache;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

/**
 * 基于java的缓存
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2020/03/06
 */

@Component
public class JVMCacheRepository implements CacheRepository {

    private ConcurrentHashMap<String, String> map = new ConcurrentHashMap();

    @Override
    public String get(String key) {
        return map.get(key);
    }

    @Override
    public boolean delete(String key) {
        if (map.contains(key)) {
            map.remove(key);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean save(String key, String toSave) {
        map.put(key, toSave);
        return true;
    }
}
