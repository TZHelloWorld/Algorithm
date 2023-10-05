package com.tz;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_322 {


    // 还是背包问题，不过这个背包不再是0-1的。而是不限量使用物品的完全背包问题。
    // 设 dp[i] 为组成金额i所需最少额硬币数量，那么考虑状态转移方程，也就是考虑最后选哪个硬币可以满足条件，且最小！
    // dp[i] = min{dp[i-c1],dp[i-c2],...,dp[i-cn]} + 1 // 有点穷举的意思
    // 那么考虑边界条件，dp[0] 表示由硬币组成数量为0 最少硬币数量，0！

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        // 本来需要取一个最大的数。但是可以考虑使用amount+1来表示最大,
        // 因为条件中是整数数组，而且吧，如果都取最小的，也就是贪心思想，很容易想到其边界，即最大值就是amount个1的硬币组成。
        Arrays.fill(dp, amount + 1);
        dp[0] = 0; // 边界条件

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                // 判断i是否比当前的硬币值大，
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }

        }
//        if (dp[amount] > amount) {
//            return -1;
//        } else {
//            return dp[amount];
//        }
        return dp[amount] > amount ? -1 : dp[amount];




    }

}
