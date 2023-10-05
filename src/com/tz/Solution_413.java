package com.tz;

public class Solution_413 {
    // 这个题目我没有看清楚题目意思，这里的子数组是需要连续的，一定注意是要连续。
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;

        int sum = 0;// 用于统计最终结果的
        int t = 0;


        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                t++;
            } else {
                t = 0;
            }
            sum += t;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3};
        Solution_413 a = new Solution_413();
        System.out.println(a.numberOfArithmeticSlices(nums));
    }
}