package main.java.algorithm.tree;

/**
 * First Bad Version
 * https://leetcode.com/problems/first-bad-version/
 * Easy
 * <p>
 * 二分查找变体
 *
 * @author zhangyanqi
 * @since 1.0 2020-03-01
 */
public class FirstBadVersion {


    //fake
    private boolean isBadVersion(int i) {
        return false;
    }

    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (isBadVersion(mid)) {
                if (!isBadVersion(mid - 1) || mid - 1 == 0) {
                    return mid;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
