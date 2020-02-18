package algorithm.list.stack;

import java.util.Stack;

/**
 * 155. Min Stack
 * https://leetcode.com/problems/min-stack/
 * easy
 *
 * 使用两个栈来实现，一个栈来按顺序存储 push 进来的数据，另一个用来存出现过的最小值
 *
 * @author xiaoqi.zyq@alibaba-inc.com
 * @date 2020/01/12
 */
public class MinStack {

    private Stack<Integer> s1 = null;
    private Stack<Integer> s2 = null;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    public void push(int x) {
        s1.push(x);
        if (s2.isEmpty()) {
            s2.push(x);
        } else {
            Integer peek = s2.peek();
            if (peek >= x) {
                s2.push(x);
            }
        }
    }

    public void pop() {
        Integer pop = s1.pop();
        if (s2.peek().equals(pop)) {
            s2.pop();
        }
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
    }
}
