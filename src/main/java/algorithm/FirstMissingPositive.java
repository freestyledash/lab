package algorithm;

/**
 * @author zhangyanqi
 * @since 1.0 2019-04-09
 * 41
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 1;
        }
        for (int i = 0; i < length; i++) {
            int current = nums[i];
            if (current <= length && current > 0 && current!=i + 1) {
                int temp = nums[current - 1];
                if(temp == current){
                    continue;
                }
                nums[current - 1] = current;
                nums[i] = temp;
                i--;
            }
        }
        for (int i = 0; i < length; i++) {
            int current = nums[i];
            if(current!=i+1){
                return i+1;
            }
            if(i==length-1){
                return length+1;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] ints = {1,2,3,4,5};
        int i = new FirstMissingPositive().firstMissingPositive(ints);
        System.out.println(i);
    }
}
