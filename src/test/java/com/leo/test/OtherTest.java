package com.leo.test;

import org.junit.Test;

public class OtherTest {

    @Test
    public void test() {
        int a = 10;
        if (a > 1) {
            System.out.println("a > 1");
        } else if (a > 5) {
            System.out.println("a > 5");
        } else {
            System.out.println(a);
        }
    }

}
