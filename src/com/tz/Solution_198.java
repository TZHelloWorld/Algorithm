package com.tz;

public class Solution_198 {

    // 设f(n)为 前n个房间的最大金额
    // 于是有 f(n) = max{nums[n]+f(n-2),f(n-1)}
    public int rob(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];// 创建一个用于存储状态的数组


        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[n - 1];

    }
}
