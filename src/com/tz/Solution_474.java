package com.tz;

public class Solution_474 {


    // 这个题目是一个比较不错的扩展题，主要是打破传统的二维dp，但是其答案有个矩阵压缩。。。


    // 设 dp[i][j][k] 表示 前 i 个字符串中，使用 j 个 0 和 k 个 1 的情况下最多可以得到的字符串数量。
    // 在考虑i=0时，需要考虑是下标还是啥。。。
    // 这里考虑的是当i=0时候，表示没有任何字符串可以使用，所以dp[0][j][k] = 0; // 边界条件

    // 那么继续考虑状态转移方程： 如果说i!=0时，那么考虑第i个字符串(下标为i-1)的，统计该字符串得到01字符数量 zeors，和ones。
    // 那么就需要判断，如果 j<zeros,或 k<ones，则不能选第i个字符串，那么dp[i][j][k] = dp[i-1][j][k];
    // 如果 j>=zeros 且 k>=ones,那么就有选第i个选择(dp[i][j][k] = dp[i-1][j-zeros][k-ones] + 1 )，
    // ,和不选第i个选择 (dp[i][j][k] = dp[i-1][j][k]).由于是最多，所以选择max。

    // 最终计算的是 dp[strs.length][m+1][n+1]

    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];// 最终计算的是dp[len][m][n]

        for (int j = 0; j <= m; j++) {
            for (int k = 0; k <= n; k++) {
                dp[0][j][k] = 0;
            }
        }

        for (int i = 1; i <= len; i++) {
            // 第i个字符串中 0 和 1 的个数
            int zeros = 0, ones = 0;
            for (int j = 0; j < strs[i - 1].length(); j++) {
                if (strs[i - 1].charAt(j) == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }


            // 状态转移方程的迭代实现
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    // 这里实现逻辑复用了代码
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= zeros && k >= ones) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    }
                }
            }
        }


        return dp[len][m][n];

    }

    public static void main(String[] args) {
        Solution_474 a = new Solution_474();
        String[] strs = {"10", "0001", "111001", "1", "0"};
        System.out.println(a.findMaxForm(strs, 5, 3));
    }
}
