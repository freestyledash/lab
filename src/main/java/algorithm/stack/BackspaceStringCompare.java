package algorithm.stack;

import java.util.Stack;

import org.junit.jupiter.api.Test;

/**
 * 844. Backspace String Compare
 * https://leetcode.com/problems/backspace-string-compare/
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2020/01/12
 */
public class BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        Stack<Character> characters = new Stack<>();
        char[] chars = S.toCharArray();
        for (char a : chars) {
            if (a == '#') {
                if (!characters.isEmpty()) {
                    characters.pop();
                }
            } else {
                characters.push(a);
            }
        }
        String concatenate = concatenate(characters);
        characters.clear();
        chars = T.toCharArray();
        for (char a : chars) {
            if (a == '#') {
                if (!characters.isEmpty()) {
                    characters.pop();
                }
            } else {
                characters.push(a);
            }
        }
        String concatenate2 = concatenate(characters);
        return concatenate.equals(concatenate2);
    }

    private String concatenate(Stack<Character> stack) {
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }

    @Test
    public void test() {
        String s1 = "y#fo##f";
        String s2 = "y#f#o##f";
        boolean b = backspaceCompare(s1, s2);
        System.out.println(b);

    }

}
