package com.tz;

import java.util.Arrays;

public class Solution_542 {

    // 这个方法的广度遍历可以学习一下。。

    // 不过我感觉这个动态规划更舒服，主要是需要两次动态规划的这个思想需要了解一下
    // 对于从矩阵只能水平向左移动 和 竖直向上移动；
    // 以及水平向右移动 和 竖直向下移动；分别计算一下动态规划

    // 先考虑水平向右移动 和 竖直向下移动过程，设dp[i][j]表示在水平向右移动 和 竖直向下移动过程过程中，位置 (i,j) 到最近的 0 的距离
    // 于是有 如果该位置(i,j) == 0 则 dp[i][j] = 0
    // 否则如果 (i,j) != 0 则 状态转移方程为：dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + 1 （注意，这里需要判断一下，数组的下标边界）

    // 对于水平向左移动 和 竖直向上移动过程 其状态转移方程为：dp[i][j] = min(dp[i+1][j], dp[i][j+1]) + 1 （这里也需要判别一下边界）

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE); // 将dp中数据初始化为最大值，这样方便后面取最小判断
        }

        // 水平向右移动 和 竖直向下移动过程
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    if (i - 1 >= 0) {
                        dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j]);
                    }
                    if (j - 1 >= 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                    }
                }

            }
        }

        //水平向左移动 和 竖直向上移动过程
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 < m) {
                    dp[i][j] = Math.min(dp[i + 1][j] + 1, dp[i][j]);
                }
                if (j + 1 < n) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }

            }

        }

        return dp;

    }

    public static void main(String[] args) {
        Solution_542 a = new Solution_542();
        int[][] mat = {{1, 0, 1}, {1, 1, 1}, {0, 1, 0}};
        a.updateMatrix(mat);
    }
}
