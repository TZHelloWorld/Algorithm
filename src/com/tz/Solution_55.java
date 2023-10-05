package com.tz;

public class Solution_55 {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int max_index = 0; // 表示从0开始走到达的最大下标

        for (int i = 0; i < n; i++) {
            if (i <= max_index) {
                max_index = Math.max(nums[i] + i, max_index);
                if (max_index >= n - 1) {
                    return true;
                }
            }
        }
        return false;


    }
}
