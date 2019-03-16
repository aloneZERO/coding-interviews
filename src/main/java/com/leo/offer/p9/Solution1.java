package com.leo.offer.p9;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。
 *
 * @author justZero
 * <a href="https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=13&tqId=11158&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking">牛客题目链接</a>
 * @since 2019/3/16
 */
public class Solution1 {

    @Test
    public void test() {
        push(1);
        push(2);
        push(3);
        assertEquals(1, pop());
        assertEquals(2, pop());
        assertEquals(3, pop());
    }

    Stack<Integer> queue = new Stack<>();
    Stack<Integer> aux = new Stack<>(); // 辅助

    public void push(int node) {
        while (!queue.isEmpty()) {
            aux.push(queue.pop());
        }
        queue.push(node);
        while (!aux.isEmpty()) {
            queue.push(aux.pop());
        }
    }

    public int pop() {
        if (queue.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        return queue.pop();
    }

}
