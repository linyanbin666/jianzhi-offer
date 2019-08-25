package com.horizon.chapter3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *  title : 正则表达式匹配
 *  url : https://www.nowcoder.com/practice/45327ae22b7b413ea21df13ee7d6429c?tpId=13&tqId=11205&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Main19 {

    /*
    // 回溯求解
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null)
            return false;
        return matchCore(str, 0, pattern, 0);
    }

    private boolean matchCore(char[] str, int sIndex, char[] pattern, int pIndex) {
        if (pIndex == pattern.length)
            return sIndex == str.length;
        // 没有*号的情况
        boolean firstMatch = sIndex < str.length && (str[sIndex] == pattern[pIndex] || pattern[pIndex] == '.');
        // 有*号的情况：
        //      1.当前字符不相同，str不动，pattern移动两位（相当于*表示前面字符出现0次）
        //      2.当前字符串相同（或pattern字符为.），
        //          1).str不动，pattern移动两位（相当于*表示前面字符出现0次）
        //          2).str移动一位，pattern移动两位（相当于*表示前面字符出现1次）
        //          3).str移动一位，pattern不动（相当于*表示前面字符串出现多次）
        if (pIndex < pattern.length - 1 && pattern[pIndex + 1] == '*') {
            if (!firstMatch) {
                return matchCore(str, sIndex, pattern, pIndex + 2);
            } else {
                return matchCore(str, sIndex, pattern, pIndex + 2) ||
                        matchCore(str, sIndex + 1, pattern, pIndex + 2) ||
                        matchCore(str, sIndex + 1, pattern, pIndex);
            }
        } else {
            return firstMatch && matchCore(str, sIndex + 1, pattern, pIndex + 1);
        }
    }
    */

    /**
     * 动态规划求解
     */
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null)
            return false;
        boolean[][] dp = new boolean[str.length + 1][pattern.length + 1];
        dp[str.length][pattern.length] = true;
        for (int i = str.length; i >= 0; i--) {
            for (int j = pattern.length - 1; j >= 0; j--) {
                boolean firstMatch = i < str.length && (str[i] == pattern[j] || pattern[j] == '.');
                if (j + 1 < pattern.length && pattern[j + 1] == '*') {
                    if (!firstMatch) {
                        dp[i][j] = dp[i][j + 2];
                    } else {
                        dp[i][j] = dp[i][j + 2] || dp[i + 1][j + 2] || dp[i + 1][j];
                    }
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    @Test
    public void test() {
        char[] str = "".toCharArray();
        char[] pattern = ".*".toCharArray();
        Assertions.assertTrue(match(str, pattern));
    }

}
