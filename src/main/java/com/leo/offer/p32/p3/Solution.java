package com.leo.offer.p32.p3;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 之字形顺序打印二叉树
 *
 * 第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 * @author justZero
 * @see <a href="https://www.nowcoder.com/practice/91b69814117f4e8097390d107d2efbe0?tpId=13&tqId=11212&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking">牛客题目链接</a>
 * @since 2019/3/23
 */
public class Solution {

    private static TreeNode testTree;

    /**
     * <pre>
     *     1
     *    / \
     *   2   3
     *  / \ / \
     * 4  5 6  7
     * </pre>
     */
    @Before
    public void setup() {
        testTree = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        testTree.left = n2;
        testTree.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = new TreeNode(8);
        n4.right = new TreeNode(9);
        n5.left = new TreeNode(10);
        n5.right = new TreeNode(11);
        n6.left = new TreeNode(12);
        n6.right = new TreeNode(13);
        n7.left = new TreeNode(14);
        n7.right = new TreeNode(15);
    }

    /**
     * 预期打印结果
     * 1
     * 3 2
     * 4 5 6 7
     * 15 14 13 12 11 10 9 8
     */
    @Test
    public void test() {
        ArrayList<ArrayList<Integer>> res = print(testTree);
        for (ArrayList<Integer> list : res) {
            list.forEach(x -> System.out.print(x+" "));
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Integer>> print(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return result;

        queue.add(root);
        boolean isReverse = false; // 是否需要翻转
        while (!queue.isEmpty()) {
            ArrayList<Integer> tempList = new ArrayList<>();
            int count = queue.size();
            while (count-- > 0) {
                TreeNode node = queue.poll();
                if (node == null) continue;
                tempList.add(node.val);

                queue.add(node.left);
                queue.add(node.right);
            }

            if (!tempList.isEmpty()) {
                if (isReverse)
                    Collections.reverse(tempList);
                isReverse = !isReverse;

                result.add(tempList);
            }
        }
        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;

    }
}
