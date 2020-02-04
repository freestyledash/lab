package algorithm;

/**
 * leetCode 4
 *
 * @author zhangyanqi
 * @since 1.0 2019-04-17
 */
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if ((length1 + length2) % 2 == 1) {
            int mid = (length1 + length2) / 2 + 1;
            int currentCount = 0;
            int index1 = 0;
            int index2 = 0;
            for (int i = 0; i < mid; i++) {
                if (length1 == 0) {
                    return nums2[mid - 1];
                }
                if (length2 == 0) {
                    return nums1[mid - 1];
                }
                boolean useNums1 = false;
                boolean canUseNums1 = true;
                boolean canUseNums2 = true;
                if (index1 > length1 - 1) {
                    canUseNums1 = false;
                }
                if (index2 > length2 - 1) {
                    canUseNums2 = false;
                }
                if (canUseNums1 && canUseNums2) {
                    int i1 = nums1[index1];
                    int i2 = nums2[index2];
                    if (i1 <= i2) {
                        useNums1 = true;
                        index1++;
                    } else {
                        index2++;
                    }
                } else {
                    if (canUseNums1) {
                        useNums1 = true;
                        index1++;
                    } else {
                        index2++;
                    }
                }
                currentCount++;
                if (currentCount == mid) {
                    if (useNums1) {
                        return nums1[index1 - 1];
                    } else {
                        return nums2[index2 - 1];
                    }
                }
            }
        } else {
            int mid = (length1 + length2) / 2;
            int r1 = 0;
            int r2 = 0;
            int currentCount = 0;
            int index1 = 0;
            int index2 = 0;
            for (int i = 0; i < mid + 1; i++) {
                if (length1 == 0) {
                    return (nums2[mid - 1] + nums2[mid]) / 2.0;
                }
                if (length2 == 0) {
                    return (nums1[mid - 1] + nums1[mid]) / 2.0;
                }
                boolean useNums1 = false;
                boolean canUseNums1 = true;
                boolean canUseNums2 = true;
                if (index1 > length1 - 1) {
                    canUseNums1 = false;
                }
                if (index2 > length2 - 1) {
                    canUseNums2 = false;
                }
                if (canUseNums1 && canUseNums2) {
                    int i1 = nums1[index1];
                    int i2 = nums2[index2];
                    if (i1 <= i2) {
                        useNums1 = true;
                        index1++;
                    } else {
                        index2++;
                    }
                } else {
                    if (canUseNums1) {
                        useNums1 = true;
                        index1++;
                    } else {
                        index2++;
                    }
                }
                currentCount++;
                if (currentCount == mid) {
                    if (useNums1) {
                        r1 = nums1[index1 - 1];
                    } else {
                        r1 = nums2[index2 - 1];
                    }
                }
                if (currentCount == mid + 1) {
                    if (useNums1) {
                        r2 = nums1[index1 - 1];
                    } else {
                        r2 = nums2[index2 - 1];
                    }
                    return (r1 + r2) / 2.0;
                }
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        MedianofTwoSortedArrays medianofTwoSortedArrays = new MedianofTwoSortedArrays();
        int[] ints1 = {2, 3};
        int[] ints2 = {1, 4};
        double medianSortedArrays = medianofTwoSortedArrays.findMedianSortedArrays(ints1, ints2);
        System.out.println(medianSortedArrays);
    }


}
