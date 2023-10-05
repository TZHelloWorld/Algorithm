package com.tz;

public class Solution_96 {

    // 返回卡特兰数 $f(n) = 1/(n+1) * C_{2n} ^{n}$
    // 其递推式为 f(1) = 1, f(n) = f(n-1) * (4*n - 2) / (n+1)

    public int numTrees(int n) {
        long ans = 1;
        for (int i = 1; i < n; i++) {
            ans = ans * (4 * i - 2) / (i + 1);
        }
        return (int) ans;


    }
}
