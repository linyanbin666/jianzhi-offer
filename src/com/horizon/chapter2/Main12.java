package com.horizon.chapter2;

/**
 *  title : 矩阵中的路径
 *  url : https://www.nowcoder.com/practice/c61c6999eecb4b8f88a98f66b273a3cc?tpId=13&tqId=11218&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Main12 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if (matrix == null || matrix.length == 0 ||
                rows < 1 || cols < 1 || str == null || str.length == 0)
            return false;
        boolean[] visited = new boolean[rows * cols];
        // 从任意一个格子开始
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hashPathCore(matrix, rows, cols, i, j, str, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hashPathCore(char[] matrix, int rows, int cols, int i, int j,
                                 char[] str, int idx, boolean[] visited) {
        if (idx == str.length)
            return true;
        boolean hasPath = false;
        int visitIdx = i * cols + j;
        if (i >= 0 && i < rows && j >= 0 && j < cols
                && matrix[visitIdx] == str[idx] && !visited[visitIdx]) {
            idx++;
            visited[visitIdx] = true;
            hasPath = hashPathCore(matrix, rows, cols, i, j - 1, str, idx, visited)
                    || hashPathCore(matrix, rows, cols, i, j + 1, str, idx, visited)
                    || hashPathCore(matrix, rows, cols, i - 1, j, str, idx, visited)
                    || hashPathCore(matrix, rows, cols, i + 1, j, str, idx, visited);
            // 回溯
            if (!hasPath) {
                visited[visitIdx] = false;
            }
        }
        return hasPath;
    }
}
