package com.horizon.chapter3;

import java.util.ArrayList;

/**
 *  title : 顺时针打印矩阵
 *  url :
 */
public class Main29 {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int start = 0, rows = matrix.length, columns = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<>();
        while (rows > start * 2 && columns > start * 2) {
            printMatrix(matrix, start, rows, columns, res);
            start++;
        }
        return res;
    }

    private void printMatrix(int[][] matrix, int start, int rows, int columns, ArrayList<Integer> res) {
        int endX = columns - 1 - start, endY = rows - 1 - start;
        // 从左到右打印一行
        for (int j = start; j <= endX; j++) {
            res.add(matrix[start][j]);
        }
        if (start < endY) {
            // 从上往下打印一列
            for (int i = start + 1; i <= endY; i++) {
                res.add(matrix[i][endX]);
            }
        }
        // 存在从上往下打印才能从右往左打印
        if (start < endX && start < endY) {
            // 从右往左打印一行
            for (int j = endX - 1; j >= start; j--) {
                res.add(matrix[endY][j]);
            }
        }
        // 从在从右往左打印才能从下往上打印
        if (start < endY - 1 && start < endX) {
           // 从下往上打印一列
           for (int i = endY - 1; i > start; i--) {
               res.add(matrix[i][start]);
           }
        }
    }

}
