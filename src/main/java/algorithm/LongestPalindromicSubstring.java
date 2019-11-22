//package algorithm;
//
///**
// * @author xiaoqi.zyq@alibaba-inc.com
// * @date 2019/08/19
// */
//public class LongestPalindromicSubstring {
//
//    public static void main(String[] args) {
//        String aba = new LongestPalindromicSubstring().longestPalindrome("babad");
//        System.out.println(aba);
//    }
//
//    public String longestPalindrome(String s) {
//        if (s.isEmpty()) {
//            return "";
//        }
//        int length = s.length();
//        int max = 0;
//        String result = "";
//        for (int pivot = 0; pivot < length; pivot++) {
//            int currentMax = 0;
//            if (pivot > 0) {
//                //不存在中心 todo
//                //存在中心
//                int leftSize = pivot;
//                //int rightSize = length - pivot - 1;
//                //for (int i = 0; i < Math.abs(rightSize - leftSize); i++) {
//                //    char leftChar = s.charAt(pivot);
//                //    char rightChar = s.charAt(pivot + i);
//                //    if (leftChar == rightChar) {
//                //        currentMax++;
//                //    } else {
//                //        break;
//                //    }
//                //}
//                if (currentMax > max) {
//                    max = currentMax;
//                    result = s.substring(pivot - max, pivot + max + 1);
//                }
//                //存在中心
//                if (leftSize > rightSize) {
//                    for (int i = 1; i < rightSize; i++) {
//                        char leftChar = s.charAt(pivot - i);
//                        char rightChar = s.charAt(pivot + i);
//                        if (leftChar == rightChar) {
//                            currentMax++;
//                        } else {
//                            break;
//                        }
//                    }
//                    if (currentMax > max) {
//                        max = currentMax;
//                        result = s.substring(pivot - max, pivot + max + 1);
//                    }
//                } else {
//                    for (int i = 1; i < leftSize; i++) {
//                        char leftChar = s.charAt(pivot - i);
//                        char rightChar = s.charAt(pivot + i);
//                        if (leftChar == rightChar) {
//                            currentMax++;
//                        } else {
//                            break;
//                        }
//                    }
//                    if (currentMax > max) {
//                        max = currentMax;
//                        result = s.substring(pivot - max, pivot + max + 1);
//                    }
//                }
//            }
//        }
//        return result;
//    }
//}
