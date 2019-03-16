package com.leo.offer.p5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 将一个字符串中的空格替换成 "%20"。
 *
 * @author justZero
 * <a href="https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking">牛客题目链接</a>
 * @since 2019/3/16
 */
public class Solution {

    @Test
    public void test() {
        StringBuffer str = new StringBuffer("We Are Happy");
        assertEquals("We%20Are%20Happy", replaceSpace(str));

        str = new StringBuffer("Hello World");
        assertEquals("Hello%20World", replaceSpace2(str));
    }

    // 解法一
    public String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll(" ", "%20");
    }

    // 解法二
    public String replaceSpace2(StringBuffer str) {
        if (str == null) {
            return null;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                res.append("%20");
            } else {
                res.append(str.charAt(i));
            }
        }
        return res.toString();
    }

}
