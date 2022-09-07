package algorithm.zj;

public class Main {


    public static void main(String[] args) {

        int[] a = new int[]{1,2,-2,-1,2};

        int fromFirst = getFromFirst(a);
        int getFromEnd = getFromEnd(a);

        System.out.println(fromFirst);
        System.out.println(getFromEnd);

    }


    public static int getFromFirst(int[] sequence) {
        int result = sequence[0];
        int currentSum = sequence[0];
        for (int i = 1; i < sequence.length; i++) {
            currentSum += sequence[i];
            if (currentSum > result) {
                result = currentSum;
            }
        }
        return result;
    }
    public static int getFromEnd(int[] sequence) {
        int result = sequence[sequence.length-1];
        int currentSum = sequence[sequence.length-1];
        for (int i = sequence.length - 2; i > 0; i--) {
            currentSum += sequence[i];
            if (currentSum > result) {
                result = currentSum;
            }
        }
        return result;
    }
}
