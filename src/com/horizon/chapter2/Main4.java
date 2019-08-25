package com.horizon.chapter2;

import org.junit.jupiter.api.Test;

/**
 *  title : 二维数组中的查找
 *  url : https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&tqId=11154&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Main4 {

    // 时间复杂度O(max(rows, cols))，空间复杂度O(1)
    public boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0)
            return false;
        boolean found = false;
        int rows = array.length, cols = array[0].length;
        int i = 0, j = cols - 1;
        while (i < rows && j >= 0) {
            if (target == array[i][j]) {
                found = true;
                break;
            } else if (target > array[i][j]) {
                i++;
            } else {
                j--;
            }
        }
        return found;
    }

}
