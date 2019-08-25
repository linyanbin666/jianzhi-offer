package com.horizon.chapter2;

/**
 *  title : 斐波那契数列
 *  url : https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=13&tqId=11160&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *  相关题目：
 *      青蛙跳台阶、2x1矩形覆盖
 */
public class Main10 {
    /*
    // 递归
    public int Fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1 || n == 2) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
    */

    // 循环，此外还有时间复杂度为O(lgn)的解法---用数学的方法，矩阵乘方
    public int Fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1 || n == 2) {
            return 1;
        }
        int num1 = 1, num2 = 1;
        for (int i = 3; i <= n; i++) {
            int sum = num1 + num2;
            num1 = num2;
            num2 = sum;
        }
        return num2;
    }

}
