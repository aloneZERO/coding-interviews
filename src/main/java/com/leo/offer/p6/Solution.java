package com.leo.offer.p6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * 从尾到头反过来打印出每个结点的值。
 *
 * @author justZero
 * <a href="https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=11156&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking">牛客题目链接</a>
 * @since 2019/3/16
 */
public class Solution {

    @Test
    public void test() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);

        String res = printListFromTailToHead(root).stream()
                .map(String::valueOf)
                .collect(Collectors.joining(""));
        assertEquals("321", res);
    }

    // 递归
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        if (listNode != null) {
            res.addAll(printListFromTailToHead(listNode.next));
            res.add(listNode.val);
        }
        return res;
    }

    // 头插法构建逆序链表
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ListNode head = new ListNode(-1);
        while (listNode != null) {
            ListNode memo = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = memo;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        head = head.next;
        while (head != null) {
            ret.add(head.val);
            head = head.next;
        }
        return ret;
    }

    // 使用栈
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty()) {
            ret.add(stack.pop());
        }
        return ret;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}