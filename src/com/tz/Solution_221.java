package com.tz;

public class Solution_221 {
    // 这个问题主要是其状态转移方程有点难想到，
    // dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])+1
    // 其中，dp[i][j] 表示以结点(i,j) 作为正方形的右下角结点最大边长。
    // 那么就需要考虑边界条件，也就是最上面横线dp[0][j] 和最左边竖线 dp[i][0],如果当前值为1，则其为1，否则为0

    public int maximalSquare(char[][] matrix) {

        int m = matrix.length, n = matrix[0].length;

        // 出错检测
        if (matrix == null || m == 0 || n == 0) {
            return 0;
        }

        int maxValue = 0;

        int[][] dp = new int[m][n]; // 创建
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 根据状态转移方程计算dp
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                    }
                }

                // 取出最大值
                maxValue = Math.max(maxValue, dp[i][j]);
            }
        }
        return maxValue * maxValue;
    }


    // 题目和 1277 题目很像
    public int countSquares(int[][] matrix) {

        int m = matrix.length, n = matrix[0].length;

        // 出错检测
        if (matrix == null || m == 0 || n == 0) {
            return 0;
        }

        int count = 0;

        int[][] dp = new int[m][n]; // 创建
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 根据状态转移方程计算dp
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                    }
                }

                // 取出最大值
                count = count + dp[i][j];
            }
        }
        return count;

    }


}
