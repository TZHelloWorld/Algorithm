package com.tz;

public class Solution_1143 {

    // 设dp[i][j] 表示text1 前i个字符，与text2前j个字符的 最长公共子序列 的长度
    // 于是考虑状态转移方程dp[i][j], 那么就需要判断一下text1[i] 和text2[j] 是否相等
    // 如果相等，则 dp[i][j] = dp[i-1][j-1] + 1,在原本基础上+1个
    // 如果不相等，那么就要考虑dp[i-1][j] 与dp[i][j-1] 哪个更大，就取哪个，即dp[i][j] = max{dp[i-1][j], dp[i][j-1]}

    // 最后考虑边界条件，如果有一个字符是空串，即dp[i][0] 和dp[0][j] 表示有一个是空串，所以其最长公共子序列长度为0

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1]; // 这里已经把dp[i][0] 和dp[0][j] 初始化为0了

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];


    }
}
