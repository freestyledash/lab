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
     * @return T
     */
    String get(String key);

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
    boolean save(String key, String toSave);

    //todo add introspect method

}
