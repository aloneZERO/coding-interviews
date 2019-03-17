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
public class Solution1 {

    @Test
    public void test1() {
        Instant start = Instant.now();
        for (int i=0; i< 40; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        Instant end = Instant.now();
        System.out.println("\n"+Duration.between(start, end).toMillis()+"ms\n");
    }

    @Test
    public void test2() {
        long start = System.nanoTime();
        for (int i=0; i< 40; i++) {
            System.out.print(fibonacci2(i) + " ");
        }
        long end = System.nanoTime();
        System.out.println("\n"+ (end-start) +"ns"); // 毫秒以内
    }

    // 递归
    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    // 非递归
    public int fibonacci2(int n) {
        if (n <= 1) {
            return n;
        }

        int pre2 = 0, pre1 = 1;
        int fib = 0;
        for (int i=2; i<= n; i++) {
            fib = pre2 + pre1;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
    }

}
