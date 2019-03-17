package com.leo.offer.p11;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * 旋转数组的最小数字
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * <p>
 * 例如数组 {3,4,5,1,2} 为 {1,2,3,4,5} 的一个旋转，该数组的最小值为1。
 * <p>
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * @author justZero
 * @see <a href="https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=11159&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking">牛客题目链接</a>
 * @since 2019/3/17
 */
public class Solution {

    @Test
    public void test() {
        int[] nums = {3, 4, 5, 1, 2};
        assertEquals(1, minNumberInRotateArray2(nums));
    }

    // 暴力思路：排个序
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        Arrays.sort(array);
        return array[0];
    }

    // 解法二
    public int minNumberInRotateArray2(int[] array) {
        if (array.length == 0) {
            return 0;
        } else if (array.length == 1) {
            return array[0];
        }

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            } else {
                if (i == array.length - 2) {
                    return array[0];
                }
            }
        }

        return 0;
    }
}
