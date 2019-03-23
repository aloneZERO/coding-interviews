package com.leo.offer.p32.p2;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 分行从上到下打印二叉树
 *
 * 和题1一样，只不过分行打印
 * @author justZero
 * @see <a href="https://www.nowcoder.com/practice/445c44d982d04483b04a54f298796288?tpId=13&tqId=11213&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking">牛客题目链接</a>
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
        ArrayList<ArrayList<Integer>> res = print(testTree);
        for (ArrayList<Integer> list : res) {
            list.forEach(x -> System.out.print(x+" "));
            System.out.println();
        }
    }

    ArrayList<ArrayList<Integer>> print(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return result;

        queue.add(root);
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
            if (!tempList.isEmpty())
                result.add(tempList);
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
