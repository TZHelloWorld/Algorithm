package com.tz;

public class Solution_416 {
    // 定义dp[i][j] 表示考虑从数组的 [0, i] 这个子区间内选取整数，在他们之中是否可以选出数，使之所有的数之和为j
    // 那么考虑状态转移方程时候 考虑选与不选。。
    // 在考虑dp[i][j]时候，表示不选 nums[i] 如果在 [0, i - 1] 这个子区间内已经有一部分元素，使得它们的和为 j ，那么 dp[i][j] = true；
    // 选nums[i] 如果在 [0, i - 1] 这个子区间内就得找到一部分元素，使得它们的和为 j - nums[i] 则 dp[i][j] = true

    // 考虑边界条件，dp[i][0] 表示前i个数选出之和为0，也就是所有数不选情况下，存在的，所以 dp[i][0] = true;

    // 该题目可以考虑将其想象为0-1背包问题，选取一部分数，使其总和为 sum/2

    public boolean canPartition(int[] nums) {
        int n = nums.length, sum = 0;


        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {   // 不能整除，而nums中又只是整数
            return false;
        }
        int targets = sum / 2;

        boolean[][] dp = new boolean[n][targets + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= targets; j++) {
                if (j >= nums[i]) { // 表示可以选第i个
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];

                }
            }
        }
        return dp[n - 1][targets];


    }

    public static void main(String[] args) {
        Solution_416 a = new Solution_416();
        int[] nums = {1, 5, 10, 6};
        System.out.println(a.canPartition(nums));

    }


}
