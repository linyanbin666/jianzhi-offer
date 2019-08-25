package com.horizon.chapter2;

/**
 *  title : 旋转数组的最小数字
 *  url : https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=11159&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Main11 {
    public int minNumberInRotateArray(int [] array) {
        if (array == null)
            return -1;
        if (array.length == 0)
            return 0;
        int low = 0, high = array.length - 1, mid = low;
        // 如果旋转数组是递增有序的，直接返回第一个元素，否则需进入循环
        while (array[low] >= array[high]) {
            // 如果到分界点时，取后一个元素即为最小值
            if (high - low == 1) {
                mid = high;
                break;
            }
            mid = (low + high) / 2;
            // 如果三个元素相等，则无法判断最小值在哪一个区间，需通过顺序遍历
            if (array[low] == array[mid] && array[mid] == array[high]) {
                return searchMinSequence(array, low, high);
            }

            // 如果下标mid元素大于等于low，则最小值在后半区间
            if (array[mid] >= array[low]) {
                low = mid;
            } else if (array[mid] <= array[high]) {
                high = mid;
            }
        }
        return array[mid];
    }

    private int searchMinSequence(int[] array, int low, int high) {
        int min = array[low];
        for (int i = low + 1; i <= high; i++) {
            if (array[i] < min)
                min = array[i];
        }
        return min;
    }
}
