package com.horizon.chapter2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

/**
 *  title : 二进制中1的个数
 *  url : https://www.nowcoder.com/practice/8ee967e43c2c4ec193b040ea7fbb10b8?tpId=13&tqId=11164&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *  解法：
 *      1. 用1做左移动统计每一位
 *      2. 利用n & (n-1)把左右边的1置0的特性计算
 *      3. 利用variable-precision swar算法计算
 */
public class Main15 {

    /*public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }*/

    // variable-precision swar算法
    public int NumberOf1(int n) {
        // 第一步
        n = (n & 0x55555555) + ((n >> 1) & 0x55555555);
        // 第二步
        n = (n & 0x33333333) + ((n >> 2) & 0x33333333);
        // 第三步
        n = (n & 0x0f0f0f0f) + ((n >> 4) & 0x0f0f0f0f);
        // 第四步
        n = (n * (0x01010101) >> 24);
        return n;
    }

    @Test
    public void test() {
        Assertions.assertEquals(3, NumberOf1(11));
    }

}
