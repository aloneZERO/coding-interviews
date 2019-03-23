package com.leo.offer.p32.p1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * 从上往下打印二叉树
 * <p>
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。即层次遍历
 *
 * @author justZero
 * @see <a href="https://www.nowcoder.com/practice/7fe2212963db4790b57431d9ed259701?tpId=13&tqId=11175&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking">牛客题目链接</a>
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
        testTree.left = n2;
        testTree.right = n3;
        n2.left = new TreeNode(4);
        n2.right = new TreeNode(5);
        n3.left = new TreeNode(6);
        n3.right = new TreeNode(7);
    }

    @Test
    public void test() {
        String res = printFromTopToBottom(testTree).stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        assertEquals("1,2,3,4,5,6,7", res);
    }

    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return result;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                continue;
            }
            result.add(node.val);

            queue.add(node.left);
            queue.add(node.right);
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
