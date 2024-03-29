package com.tz;

public class Solution_62 {

    // 一眼动态规划，设置 dp[i][j]表示机器人到 i，j 的路径条数

    // 由于只能向下或者向右。
    // 于是， dp[i][j] = dp[i-1][j] + dp[i][j-1]
    // 边界， dp[i][0] = dp[0][j] = 1

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];


    }
}
