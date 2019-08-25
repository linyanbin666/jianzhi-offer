package com.horizon.chapter3;

import org.junit.jupiter.api.Test;

/**
 *  title : 打印从1到最大的n位数
 *  detail : 输入数字n, 按顺序打印出从1到最大的n位十进制数。比如输入3， 则打印1、2、3一直打印到最大的3位数999.
 */
public class Main17 {

    // 全排列
    public void printToMaxOfNDigits(int n) {
        if (n <= 0)
            return;
        char[] numbers = new char[n];
        for (int i = 0; i < 10; i++) {
            numbers[0] = (char) ('0' + i);
            printToMaxOfNDigitsRecursion(numbers, n, 0);
        }
    }

    private void printToMaxOfNDigitsRecursion(char[] numbers, int n, int idx) {
        if (idx == n - 1) {
            printNumber(numbers);
            return;
        }
        for (int i = 0; i < 10; i++) {
            numbers[idx + 1] = (char) (i + '0');
            printToMaxOfNDigitsRecursion(numbers, n, idx + 1);
        }
    }

    private void printNumber(char[] numbers) {
        boolean isBegin = false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != '0' && !isBegin)
                isBegin = true;
            if (isBegin) {
                System.out.print(numbers[i]);
            }
        }
        System.out.println();
    }

    @Test
    public void test() {
        printToMaxOfNDigits(3);
    }
}
