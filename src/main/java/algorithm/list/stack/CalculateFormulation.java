package algorithm.list.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.jupiter.api.Test;

/**
 * 使用堆进行计算
 * enlighten
 * heuristic
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2020/01/12
 */
public class CalculateFormulation {

    /*
    https://juejin.im/post/5d25d6206fb9a07ec7554419
    https://www.zhihu.com/question/25097763

    特征：中缀表达式 容易看懂，但是不方便计算，后缀表达式方便计算
    思路：
        1.中缀表达式转后缀表达式
        2.计算后缀表达式
     */

    /**
     * 操作符号
     */
    enum Operator {
        ADDITION("+", 1) {
            @Override
            float operate(float a, float b) {
                return a + b;
            }
        },
        SUBTRACTION("-", 1) {
            @Override
            float operate(float a, float b) {
                return a - b;
            }
        },
        MULTIPLICATION("*", 1) {
            @Override
            float operate(float a, float b) {
                return a * b;
            }
        },
        DIVISION("/", 2) {
            @Override
            float operate(float a, float b) {
                return a / b;
            }
        },
        LEFTPARENTHESIS("(", 0) {
            @Override
            float operate(float a, float b) {
                throw new RuntimeException("无效的执行");
            }
        },
        RIGHTPARENTHESIS(")", 0) {
            @Override
            float operate(float a, float b) {
                throw new RuntimeException("无效的执行");
            }
        };

        private String symbol;
        //值越大，优先级越高
        private int priority;

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        Operator(String symbol, int priority) {
            this.symbol = symbol;
            this.priority = priority;
        }

        abstract float operate(float a, float b);

        static boolean isOperator(String s) {
            Operator[] values = Operator.values();
            for (Operator operator : values) {
                if (operator.symbol.equals(s)) {
                    return true;
                }
            }
            return false;
        }

        static Operator getOperator(String s) {
            Operator[] values = Operator.values();
            for (Operator operator : values) {
                if (operator.symbol.equals(s)) {
                    return operator;
                }
            }
            throw new IllegalArgumentException("非法的操作符号");
        }

    }

    /**
     * main entrance
     *
     * @param toCal 需要被计算的表达式
     */
    public float calculate(String toCal) {
        //将表达式转换为String list  这个 list 是一个中缀表达式
        List<String> list = convertStringToSegment(toCal);
        System.out.println("markUp");
        //将中缀表达式转换为后缀表达式
        list = convertInfixExpressionToSuffixExpression(list);
        System.out.println("markUp");
        //计算
        float v = realCalculate(list);
        System.out.println("markUp");
        return v;
    }

    public List<String> convertStringToSegment(String toCal) {
        toCal = toCal.trim();
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

    /**
     * 将中缀表达式修改为前缀表达式
     *
     * @param infixExpression 中缀表达式
     * @return suffixExpression
     */
    public List<String> convertInfixExpressionToSuffixExpression(List<String> infixExpression) {
        ArrayList<String> result = new ArrayList<>(infixExpression.size());
        Stack<String> mathOperations = new Stack<>();
        for (String element : infixExpression) {
            //如果是数字，直接弹出
            boolean isOperator = Operator.isOperator(element);
            if (!isOperator) {
                result.add(element);
            } else {
                Operator operator = Operator.getOperator(element);
                //如果是右括号，弹出到上一个左括号为止,且左右括号不进结果list
                if (operator.equals(Operator.RIGHTPARENTHESIS)) {
                    while (true) {
                        String pop = mathOperations.pop();
                        if (pop.equals(Operator.LEFTPARENTHESIS.getSymbol())) {
                            break;
                        }
                        result.add(pop);
                    }
                    continue;
                }
                //如果当前插入的是运算符或者左括号
                while (true) {
                    if (mathOperations.isEmpty() || element.equals(Operator.LEFTPARENTHESIS)) {
                        mathOperations.push(element);
                        break;
                    }
                    String peek = mathOperations.peek();
                    Operator topOperator = Operator.getOperator(peek);
                    //如果上级是是左括号，则插入
                    if (topOperator.equals(Operator.LEFTPARENTHESIS)) {
                        mathOperations.push(element);
                        break;
                    }
                    //当前操作的优先级较栈顶优先级小或者相等，栈顶的先弹出
                    if (topOperator.getPriority() >= operator.getPriority()) {
                        String pop = mathOperations.pop();
                        result.add(pop);
                        continue;
                    } else {
                        mathOperations.push(element);
                        break;
                    }
                }
            }
        }
        while (!mathOperations.isEmpty()) {
            String pop = mathOperations.pop();
            result.add(pop);
        }
        return result;
    }

    /**
     * 计算
     *
     * @param suffixExpression 后缀表达式
     * @return
     */
    public float realCalculate(List<String> suffixExpression) {
        Stack<Float> sop = new Stack<>();
        for (String ele : suffixExpression) {
            if (sop.isEmpty()) {
                Float push = sop.push(Float.valueOf(ele));
                continue;
            } else {
                boolean isOp = Operator.isOperator(ele);
                if (isOp) {
                    Operator operator = Operator.getOperator(ele);
                    Float pop1 = sop.pop();
                    Float pop2 = sop.pop();
                    float operate = operator.operate(pop2, pop1);
                    sop.add(operate);
                } else {
                    sop.push(Float.valueOf(ele));
                }
            }
        }
        return sop.pop();
    }

    @Test
    public void test() {
        //String toCal = "(1+2+3)/10*2";
        String toCal = "1+3-2";
        float calculate = calculate(toCal);
        System.out.println(calculate);
        System.out.println("triumph!");
    }

}
