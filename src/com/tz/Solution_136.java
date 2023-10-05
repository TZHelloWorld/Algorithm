package com.tz;

public class Solution_136 {

    // 这个题目的话一般用暴力破解，两个循环，判断，但是题目要求线性时间内
    // 这个思路开始没怎么想明白，但是看了官网 豁然开朗啊
    // 主要是每个数要么只有两个，要么只有一个，并且一个的有且只有一个
    // 那么就可以找一个函数，对于数字 a ,有 f(a) = a ,且 f(a) * f(f(a)) = f(a) = a ,这个就是异或 ^

    public int singleNumber(int[] nums) {

        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }

        return ans;
    }
}
