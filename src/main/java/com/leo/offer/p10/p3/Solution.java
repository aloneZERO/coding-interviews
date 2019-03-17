package com.leo.offer.p10.p3;

import org.junit.Test;

/**
 * 跳台阶
 * <p>
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。
 * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * @author justZero
 * @see <a href="https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=13&tqId=11161&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking">牛客题目链接</a>
 * @since 2019/3/17
 */
public class Solution {

    @Test
    public void test() {
        for (int i=0; i<= 10; i++) {
            System.out.print(jumpFloor(i)+" ");
        }
    }

    // 本质依然是斐波那契数列
    public int jumpFloor(int target) {
        if (target <= 2) {
            return target;
        }
        int pre2 = 1, pre1 = 2;
        int result = 1;
        for (int i = 3; i <= target; i++) {
            result = pre2 + pre1;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }

}
