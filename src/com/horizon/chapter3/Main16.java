package com.horizon.chapter3;

import org.junit.jupiter.api.Test;

/**
 *  title : 数值的整数次方
 *  url : https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00?tpId=13&tqId=11165&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Main16 {

    /*
    // 常规解法
    public double Power(double base, int exponent) {
        if (base == 0.0 && exponent < 0) {
            throw new RuntimeException("base is zero and exponent less than zero.");
        }
        int absExponent = Math.abs(exponent);
        double result = 1.0;
        for (int i = 0; i < absExponent; i++) {
            result *= base;
        }
        if (exponent < 0) {
            result = 1.0 / result;
        }
        return result;
    }
    */

    // 分治求解
    public double Power(double base, int exponent) {
        if (base == 0.0 && exponent < 0) {
            throw new RuntimeException("base is zero and exponent less than zero.");
        }
        int absExponent = Math.abs(exponent);
        double result = powerWithUnsignedExponent(base, absExponent);
        if (exponent < 0) {
            result = 1.0 / result;
        }
        return result;
    }

    private double powerWithUnsignedExponent(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        double result = powerWithUnsignedExponent(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1) {
            result *= base;
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(Power(0.1, -1));
    }
}
