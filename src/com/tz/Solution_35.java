package com.tz;

public class Solution_35 {

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int ans = n; // 用于记录答案。这个更新也可以设置为0，不给在后序更新时候得换个位置

        while (left <= right) {
            int mid = (right + left) >> 1;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;

    }
}
