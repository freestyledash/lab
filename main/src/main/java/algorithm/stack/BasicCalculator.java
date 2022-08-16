package main.java.algorithm.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.jupiter.api.Test;

/**
 * 224. Basic Calculator
 * https://leetcode.com/problems/basic-calculator/
 * hard
 * 居然超时...
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2020/01/13
 */
public class BasicCalculator {

    enum Operator {

        ADDITION("+") {
            @Override
            int execute(int a, int b) {
                return a + b;
            }
        },

        MINUS("-") {
            @Override
            int execute(int a, int b) {
                return a - b;
            }
        },

        LEFT_PARENTHESIS("(") {
            @Override
            int execute(int a, int b) {
                throw new RuntimeException();
            }
        },

        RIGHT_PARENTHESIS(")") {
            @Override
            int execute(int a, int b) {
                throw new RuntimeException();
            }
        };

        public String symbol;

        abstract int execute(int a, int b);

        Operator(String symbol) {
            this.symbol = symbol;
        }

        static boolean isOperator(String s) {
            Operator[] values = Operator.values();
            for (Operator o : values) {
                if (o.symbol.equals(s)) {
                    return true;
                }
            }
            return false;
        }

        static Operator getOperator(String s) {
            Operator[] values = Operator.values();
            for (Operator o : values) {
                if (o.symbol.equals(s)) {
                    return o;
                }
            }
            throw new RuntimeException();
        }
    }

    public int calculate(String s) {
        List<String> list = convertToElements(s);
        list = convertToSuffixExpression(list);
        if (list.size() == 0) {
            return 0;
        }
        if (list.size() == 1) {
            return Integer.valueOf(list.get(0));
        }

        int calculate = calculate(list);
        return calculate;
    }

    private List<String> convertToSuffixExpression(List<String> expression) {
        List<String> result = new ArrayList<>();
        Stack<String> stack = new Stack<String>();
        for (String s : expression) {
            if (!Operator.isOperator(s)) {
                result.add(s);
            } else {
                if (stack.isEmpty()) {
                    stack.push(s);
                } else {
                    String peek = stack.peek();
                    Operator operator = Operator.getOperator(s);
                    if (operator.equals(Operator.LEFT_PARENTHESIS)) {
                        stack.push(s);
                        continue;
                    }
                    if (operator.equals(Operator.RIGHT_PARENTHESIS)) {
                        while (!stack.empty()) {
                            String pop = stack.pop();
                            if (pop.equals(Operator.LEFT_PARENTHESIS.symbol)) {
                                break;
                            }
                            result.add(pop);
                        }
                        continue;
                    }
                    while (true) {
                        if (!stack.isEmpty()) {
                            peek = stack.peek();
                            if (!peek.equals(Operator.LEFT_PARENTHESIS.symbol)) {
                                result.add(stack.pop());
                            } else {
                                stack.push(s);
                                break;
                            }
                        } else {
                            stack.push(s);
                            break;
                        }
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    private List<String> convertToElements(String toCal) {
        String temp = "";
        for (int i = 0; i < toCal.length(); i++) {
            char c = toCal.charAt(i);
            if (c != ' ') {
                temp += c;
            }
        }
        toCal = temp;
        char[] chars = toCal.toCharArray();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            String s = String.valueOf(chars[i]);
            if (Operator.isOperator(s)) {
                list.add(s);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                for (; i < chars.length; i++) {
                    String m = String.valueOf(chars[i]);
                    if (Operator.isOperator(m)) {
                        i--;
                        break;
                    }
                    stringBuilder.append(m);
                }
                list.add(stringBuilder.toString());
            }
        }
        return list;

    }

    private int calculate(List<String> suffixExpression) {
        Stack<String> strings = new Stack<>();
        for (String s : suffixExpression) {
            if (!Operator.isOperator(s)) {
                strings.push(s);
            } else {
                Operator operator = Operator.getOperator(s);
                String pop = strings.pop();
                String pop1 = strings.pop();
                Integer execute = operator.execute(Integer.valueOf(pop1), Integer.valueOf(pop));
                strings.push(execute.toString());
            }
        }
        return Integer.valueOf(strings.pop());
    }

    @Test
    public void test() {
        //String toTest = "1+(1-2)";
        //String toTest ="1 + 1";
        //String toTest ="1 ";
        String toTest = "(1+(4+5+2)-3)+(6+8)";
        //String toTest = "(1+(1+1+2))";
        int calculate = calculate(toTest);
        System.out.println(calculate);
        //System.out.println("1 2 4".trim());
    }
}
