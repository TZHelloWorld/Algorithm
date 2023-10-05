package com.tz;

public class Solution_213 {


    // 主要是得多考虑 头 和 尾 的情况，也就是 保证第一间房屋和最后一间房屋不同时偷窃
    // 分两种情况，第一间房不偷窃， 数组[1..n-1]
    // 最后一间房不偷窃，数组[0..n-2]
    public int rob(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // 第一间房不偷窃， 数组[1..n-1]
        int first, second, ans = 0;

        first = nums[1];
        second = Math.max(nums[1], nums[2]);

        for (int i = 3; i < nums.length; i++) {
            int temp = second;
            second = Math.max(nums[i] + first, second);
            first = temp;
        }
        ans = Math.max(second, ans);

        // 最后一间房不偷窃，数组[0..n-2]
        first = nums[0];
        second = Math.max(nums[0], nums[0]);

        for (int i = 2; i < nums.length - 1; i++) {
            int temp = second;
            second = Math.max(nums[i] + first, second);
            first = temp;
        }
        ans = Math.max(second, ans);
        return ans;

    }


}
