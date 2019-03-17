package com.leo.offer.p10.p1;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;

/**
 * 求斐波那契数列的第 n 项
 *
 * @author justZero
 * @see <a href="https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=13&tqId=11160&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking">牛客题目链接</a>
 * @since 2019/3/17
 */
public class Solution2 {

    @Test
    public void test1() {
        for (int i=0; i< 40; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    // 如果已经 n 小于 40，那么可以空间换时间，每次结果都存在数组中，
    // 之后 O(1) 的时间复杂度就可以得到结果。
    private int[] fib = new int[40];
    public Solution2() {
        fib[1] = 1;
        fib[2] = 1;
        for (int i=3; i< fib.length; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
    }

    // 非递归
    public int fibonacci(int n) {
        return fib[n];
    }

}
