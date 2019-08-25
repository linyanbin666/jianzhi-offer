package com.horizon.chapter2;

/**
 *  title : 机器人的运动范围
 *  url : https://www.nowcoder.com/practice/6e5207314b5241fb83f2329e89fdecc8?tpId=13&tqId=11219&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Main13 {
    public int movingCount(int threshold, int rows, int cols)
    {
        if (threshold < 0 || rows <= 0 || cols <= 0)
            return 0;
        boolean[] visited = new boolean[rows * cols];
        return movingCountCore(threshold, rows, cols, 0, 0, visited);
    }

    private int movingCountCore(int threshold, int rows, int cols,
                                int i, int j, boolean[] visited) {
        int count = 0;
        // 满足条件则可以走
        if (check(threshold, rows, cols, i, j, visited)) {
            visited[cols * i + j] = true;

            count = 1 + movingCountCore(threshold, rows, cols, i - 1, j, visited)
                    + movingCountCore(threshold, rows, cols, i + 1, j, visited)
                    + movingCountCore(threshold, rows, cols, i, j - 1, visited)
                    + movingCountCore(threshold, rows, cols, i, j + 1, visited);
        }
        return count;
    }

    private boolean check(int threshold, int rows, int cols,
                          int i, int j, boolean[] visited) {
        if (i >= 0 && i < rows && j >= 0 && j < cols
                && !visited[cols * i + j] && getDigitSum(i) + getDigitSum(j) <= threshold) {
            return true;
        }
        return false;
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
