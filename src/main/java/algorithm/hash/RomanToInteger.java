package algorithm.hash;

import java.util.*;

/**
 * 13. Roman to Integer
 * https://leetcode.com/problems/roman-to-integer/
 * Easy
 * <p>
 * 首先，了解下罗马数字的构造原理：
 * <p>
 * definition
 * <p>
 * 从左往右看
 * if (pre < next)
 * next - all pre those less than next and plus
 * https://www.luomashuzi.com/
 * <p>
 * <p>
 * 使用stack
 * 关键:出栈的最后一个元素可能是需要被plus的，而不是被subtract
 *
 * @author zhangyanqi
 * @since 1.0 2020-02-29
 */
public class RomanToInteger {

    /*
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
     */

    public int romanToInt(String s) {
        //index 越小,值越小
        List<Character> order = Arrays.asList('I', 'V', 'X', 'L', 'C', 'D', 'M');
        List<Integer> list = new ArrayList<>();
        Stack<Character> stack = new Stack();
        char[] arr = s.toCharArray();
        for (char i : arr) {
            //栈为空，入栈
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            //如果当前插入的值,位置比上一个值更加靠后，说明插入的值更大,把前面的当成减数，出栈
            if (order.indexOf(i) > order.indexOf(stack.peek())) {
                stack.push(i);
                emptifyStack(stack, list);
                continue;
            }
            stack.push(i);
        }

        //clean rest ele in stack
        emptifyStack(stack, list);
        int result = 0;
        for (int i : list) {
            result += i;
        }
        return result;
    }


    private void emptifyStack(Stack<Character> stack, List<Integer> result) {
        if (stack.isEmpty()) {
            return;
        }
        System.out.println("当前清栈:");
        int plus = getValue(stack.pop());
        int flag = plus;
        System.out.println("+" + plus);
        int minus = 0;
        while (!stack.isEmpty()) {
            char pop = stack.pop();
            int value = getValue(pop);
            if (value < flag) {
                minus += value;
                System.out.println("-" + value);
            } else {
                plus += value;
                System.out.println("+" + value);
            }
        }
        int e = plus - minus;
        System.out.println("清栈结果" + e);
        result.add(e);
    }


    private int getValue(char singleMark) {
        switch (singleMark) {
            case 'I': {
                return 1;
            }
            case 'V': {
                return 5;
            }
            case 'X': {
                return 10;
            }
            case 'L': {
                return 50;
            }
            case 'C': {
                return 100;
            }
            case 'D': {
                return 500;
            }
            case 'M': {
                return 1000;
            }
            default:
                throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
//        int xxx = romanToInteger.romanToInt("MCDXXXVII");
        int xxx = romanToInteger.romanToInt("MDCCCLXXXIV");
        System.out.println(xxx);
    }
}
