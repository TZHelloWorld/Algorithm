package com.tz;

public class Solution_300 {
    // 定义dp[i] 表示考虑nums从前i个元素，且以第i个元素结尾的最长上升子序列的长度

    // 于是当求得了0~i-1的dp后，考虑dp[i],只需要判断第i个与0~i-1的数是否构成最长上升子序列，如果构成，则加一，并从上述0~i-1计算过后的数据中选出一个最大的。

    // 这里好像有个更快的方法，有时间可以学习一下

    public int lengthOfLIS(int[] nums) {

        int m = nums.length;
        if (m <= 0) { // 边界判断
            return 0;
        }

        int[] dp = new int[m];
        dp[0] = 1;
        int maxValue = 1; // 用于记录整个遍历过程中最长的那个

        for (int i = 1; i < m; i++) {
            dp[i] = 1; // 表示如果不考虑 0~i-1 的情况下

            // 考虑0~i-1 的情况下，选出最长的
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxValue = Math.max(maxValue, dp[i]);
        }
        return maxValue;

    }

}
