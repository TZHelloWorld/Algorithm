package com.tz;

import java.util.Arrays;

public class Solution_279 {

    // 这题有点贪心的思想在里面，设dp[i] 表示数字i 最少可以由几个完全平方数相加构成。
    //那么位置 i 的数量 dp[i] 只依赖 i - k * k 的位置(注意，这里的k是泛指，也就是说要遍历的，其中 0< k*k <= i)，
    // 比如说，对于位置i，其需要注意 i - 1、i - 4、i - 9 ，是否满足完全平方分割的条件。
    // 因此dp[i] 可以取的最小值即为1 + min(dp[i-1], dp[i-4], dp[i-9] ... )。

    public int numSquares(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }

        }
        return dp[n];

    }
}
