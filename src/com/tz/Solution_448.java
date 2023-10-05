package com.tz;

import java.util.ArrayList;
import java.util.List;

public class Solution_448 {
    // 这个图很生动形象，只不过对于官方的操作，其是将其求负数操作，而官方操作则是加n，并通过大于n的操作来判断。
    //https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/solutions/1/yi-zhang-dong-tu-bang-zhu-li-jie-yuan-di-uign/?envType=featured-list&envId=2cktkvj%3FenvType%3Dfeatured-list&envId=2cktkvj

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // 之所以需要判断一下，主要是防止有偶数的相同数导致乘-1，变为了正数，后面不好统计
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }

        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
