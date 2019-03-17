package com.leo.offer.p10.p2;

import org.junit.Test;

/**
 * 矩形覆盖
 * <p>
 * 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
 *
 * @author justZero
 * @see <a href="https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6?tpId=13&tqId=11163&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking">牛客题目链接</a>
 * @since 2019/3/17
 */
public class Solution {

    @Test
    public void test() {
        for (int i=0; i<= 10; i++) {
            System.out.print(rectCover(i) + " ");
        }
    }

    // 本质还是斐波那契数列
    public int rectCover(int target) {
        if (target <= 2) {
            return target;
        }
        int pre2 = 1, pre1 = 2;
        int res = 0;
        for (int i=3; i<= target; i++) {
            res = pre2 + pre1;
            pre2 = pre1;
            pre1 = res;
        }
        return res;
    }

}
