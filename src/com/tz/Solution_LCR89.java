package com.tz;

public class Solution_LCR89 {
    public static void main(String[] args) {

    }

    // 考虑dp[i] 表示前i个数的最高金额
    // dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
    public int rob(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;
        int first = nums[0], second = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int temp = second;
            second = Math.max(nums[i] + first, second);
            first = temp;
        }

        return second;

    }

}
