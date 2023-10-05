package com.tz;

public class Solution_34 {

    // 两次二分查找，第一次查找target第一次出现的位置，第二次查找最后一次出现的位置
    // 主要是二分查找的指针判断，==target，>target，<target指针该如何赋值。
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;

        int left = 0, right = nums.length - 1;
        // 第一次二分
        while (left <= right) {
            int mid = (left + right) >> 1; // 类似于除2操作，但是不容易溢出

            if (nums[mid] == target) {
                ans[0] = mid;
                right = mid - 1; // 未必是第一个，然后从mid左边找
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // 第二次二分
        left = 0;
        right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) >> 1; // 类似于除2操作，但是不容易溢出

            if (nums[mid] == target) {
                ans[1] = mid;
                left = mid + 1; // 未必是最后一个，然后从mid右边找
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;


    }

}
