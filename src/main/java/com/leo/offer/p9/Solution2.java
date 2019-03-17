package com.leo.offer.p9;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。
 *
 * @author justZero
 * @see <a href="https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=13&tqId=11158&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking">牛客题目链接</a>
 * @since 2019/3/16
 */
public class Solution2 {

    @Test
    public void test() {
        push(1);
        push(2);
        push(3);
        assertEquals(1, pop());
        assertEquals(2, pop());
        assertEquals(3, pop());
    }

    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();

    public void push(int node) {
        in.push(node);
    }

    public int pop() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }

        if (out.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }

        return out.pop();
    }
}
