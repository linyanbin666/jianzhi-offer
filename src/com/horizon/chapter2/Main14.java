package com.horizon.chapter2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *  title : 剪绳子
 *  detail : 给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n > 1 并且 m > 1），每段绳子的长度记为k[0],k[1],...,k[m]。
 *  请问k[0] X k[1] X ... X k[m]可能的最大乘积是多少？
 */
public class Main14 {

    // 动态规划
    public int maxProductAfterCuttingSolution1(int length) {
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;

        // 数组中第i个元素表示把长度为i的绳子剪成若干段之后各段长度乘积的最大值
        int[] products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        for (int i = 4; i <= length; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (max < product) {
                    max = product;
                }
            }
            products[i] = max;
        }
        return products[length];
    }

    // 贪心算法，当n >= 5时，剪一段3，当n == 4时，剪两段2
    public int maxProductAfterCuttingSolution2(int length) {
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;

        // 尽可能多地剪去长度为3的绳子
        int timesOf3 = length / 3;

        // 当绳子最后剩下的长度为4的时候，不能再剪去长度为3的绳子段
        if (length - timesOf3 * 3 == 1)
            timesOf3 -= 1;

        int timesOf2 = (length - timesOf3 * 3) / 2;

        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }

    @Test
    public void test() {
        int length = 8; // 2 3 3
        Assertions.assertEquals(18, maxProductAfterCuttingSolution1(length));
        Assertions.assertEquals(18, maxProductAfterCuttingSolution2(length));
    }
}

