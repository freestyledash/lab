package feature.cache;

/**
 * 基于java的缓存
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2020/03/06
 */
public class JVMCacheRepository implements CacheRepository {

    @Override
    public <T> T get(String key, Class<T> type) {
        return null;
    }

    @Override
    public boolean delete(String key) {
        return false;
    }

    @Override
    public boolean save(String key, Object toSave) {
        return false;
    }
}
