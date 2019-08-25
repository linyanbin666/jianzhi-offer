package com.horizon.chapter2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * title : 数组中重复的数字：
 * url : https://www.nowcoder.com/practice/623a5ac0ea5b4e5f95552655361ae0a8?tpId=13&tqId=11203&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Main3 {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        // 判断
        if (numbers == null || numbers.length == 0 || numbers.length != length)
            return false;
        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > length - 1)
                return false;
        }
        int i = 0;
        while (i < length) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers, i, numbers[i]);
            }
            i++;
        }
        return false;
    }

    private void swap(int[] numbers, int i, int j) {
        if (i == j)
            return;
        numbers[i] ^= numbers[j];
        numbers[j] ^= numbers[i];
        numbers[i] ^= numbers[j];
    }

    @Test
    public void test() {
        int[][] arr = {
                {2,3,1,0,2,5,3},
                {1, 2, 3, 4, 4},// 没有重复的
                {}, // 空数组
                null, // null
        };
        boolean[] res = {true, true, false, false};
        for (int i = 0; i < arr.length; i++) {
            int[] dup = new int[1];
            Assertions.assertEquals(duplicate(arr[i], arr[i] == null ? 0 : arr[i].length, dup), res[i]);
        }
    }
}
