package feature.cache;

import java.util.List;

/**
 * cache core provide cache CRUD
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2020/03/06
 */
public interface CacheRepository {

    /**
     * @param condition
     * @param <T>
     * @param <V>
     * @return
     */
    <T, V> T getOne(V condition);

    /**
     * @param condition
     * @param <T>
     * @param <V>
     * @return
     */
    <T, V> List<T> getList(V condition);

    /**
     * @param condition
     * @param <V>
     * @return
     */
    <V> boolean detete(V condition);

}
