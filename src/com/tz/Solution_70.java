package com.tz;

public class Solution_70 {

    // 设f(n)表示用于返回n阶台阶到达楼顶的方法，于是有状态转移方程 f(n) = f(n-1) + f(n-2)
    public int climbStairsByCur(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }

        return climbStairsByCur(n - 1) + climbStairsByCur(n - 2);

    }

    // 官方解析比较牛皮，有个通项公式挺不错。。
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int[] array = new int[n];

        array[0] = 1;
        array[1] = 1;

        for (int i = 2; i < n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }


        return array[n - 1] + array[n - 2];

    }

}
