package com.horizon.chapter3;

/**
 *  title : 调整数组顺序使奇数位于偶数前面
 *  url : https://www.nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593?tpId=13&tqId=11166&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Main21 {

    // 借助辅助数组，空间复杂度O(n)，时间复杂度O(n)
    public void reOrderArray(int [] array) {
        int[] tempArr = new int[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                tempArr[index++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 0) {
                tempArr[index++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = tempArr[i];
        }
    }

}
