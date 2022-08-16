package main.java.algorithm.stack;

import java.util.Stack;

/**
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 * easy
 * 验证括号
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2020/01/12
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        char leftParenthesis = '(';
        char rightParenthesis = ')';
        char leftSquareBrackets = '[';
        char rightSquareBrackets = ']';
        char leftCurlyBrace = '{';
        char rightCurlyBrace = '}';

        if (s == null || s.isEmpty()) {
            return true;
        }

        char[] chars = s.toCharArray();
        Stack<Character> characters = new Stack<>();
        for (char i : chars) {
            if (i == leftParenthesis || i == leftSquareBrackets || i == leftCurlyBrace) {
                characters.push(i);
            } else {
                if (characters.isEmpty()) {
                    return false;
                }
                Character peek = characters.peek();
                switch (peek) {
                    case '(': {
                        if (i == ')') {
                            characters.pop();
                        } else {
                            return false;
                        }
                        break;
                    }
                    case '[': {
                        if (i == ']') {
                            characters.pop();
                            break;
                        } else {
                            return false;
                        }
                    }
                    case '{': {
                        if (i == '}') {
                            characters.pop();
                        } else {
                            return false;
                        }
                        break;
                    }
                    default:
                        return false;
                }
            }
        }
        if(characters.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
