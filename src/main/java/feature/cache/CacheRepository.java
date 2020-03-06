package feature.cache;

/**
 * cache core provide cache CRUD
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2020/03/06
 */
public interface CacheRepository {

    /**
     * get
     *
     * @param <T>  T
     * @param type type
     * @return T
     */
    <T> T get(String key, Class<T> type);

    /**
     * delete
     *
     * @param key
     * @return boolean
     */
    boolean delete(String key);

    /**
     * save
     *
     * @param key
     * @param toSave
     * @return
     */
    boolean save(String key, Object toSave);

}
