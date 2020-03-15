package feature.cache;

/**
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2020/03/06
 */

@FunctionalInterface
public interface KeyExtractor<T> {

    /**
     * 提取key
     *
     * @param t
     * @return
     */
    String extract(T t);

}
