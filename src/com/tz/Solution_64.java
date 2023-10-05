package com.tz;

public class Solution_64 {

    public int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n]; // dp[i][j] 用于表示从左上到grid[i][j]的数字之和最小

        dp[0][0] = grid[0][0];
        // 由于只能向下和向右，所以对于dp[i][] 和dp[][j] 计算属于边界计算
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }


        return dp[m - 1][n - 1];


    }

    // 这里发现有个比较有意思的地方， 就是可以不需要额外的二维数组。。。
    // 重用 grid数组。
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;


        for (int i = 1; i < m; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            grid[0][j] = grid[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }

        return grid[m - 1][n - 1];


    }

    public static void main(String[] args) {
        int[][] array = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        Solution_64 a = new Solution_64();

        System.out.println(a.minPathSum(array));
    }

}
