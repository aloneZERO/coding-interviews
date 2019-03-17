package com.leo.offer.p10.p4;

import org.junit.Test;

import java.util.Arrays;

/**
 * 变态跳台阶
 * <p>
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。
 * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * @author justZero
 * @see <a href="https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&tqId=11162&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking">牛客题目链接</a>
 * @since 2019/3/17
 */
public class Solution {

    @Test
    public void test() {
        for (int i=0; i<= 10; i++) {
            System.out.print(jumpFloorII(i)+" ");
        }
        System.out.println();
        for (int i=0; i<= 10; i++) {
            System.out.print(jumpFloorII2(i)+" ");
        }
    }

    // 数学推导
    // f(n-1) = f(n-2) + f(n-3) + ... + f(0) --- (1)
    // f(n) = f(n-1) + f(n-2) + ... + f(0) --- (2)
    // (2)-(1) 得 f(n) = 2*f(n-1)
    public int jumpFloorII(int target) {
        if (target <= 0) {
            return 0;
        }
        return (int) Math.pow(2, target-1);
    }

    // 动态规划
    public int jumpFloorII2(int target) {
        if (target <= 0) {
            return 0;
        }
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < target; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target - 1];
    }
}
