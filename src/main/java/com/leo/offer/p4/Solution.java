package com.leo.offer.p4;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * 给定一个二维数组，其每一行从左到右递增排序，
 * 从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 *
 * @author justZero
 * <a href="https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&tqId=11154&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking">牛客题目链接</a>
 * @since 2019/3/16
 */
public class Solution {

    @Test
    public void test() {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        assertTrue(find(9, matrix));
        assertFalse(find(100, matrix));
    }

    /**
     * 从右上角开始
     * 比目标小，就接着向下找
     * 比目标大，就向左找
     */
    public boolean find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int rows = array.length, cols = array[0].length;
        int r = 0, c = cols - 1;
        while (r <= rows - 1 && c >= 0) {
            if (target == array[r][c]) {
                return true;
            } else if (target > array[r][c]) {
                r++;
            } else {
                c--;
            }
        }
        return false;
    }

}
