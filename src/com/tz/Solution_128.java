package com.tz;

import java.util.HashSet;
import java.util.Set;

public class Solution_128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num); // 添加到set并去重。
        }


        int ans = 0;// 记录最长连续序列的长度

        // 遍历set中的，可以少遍历重复的数据
        for (int num : set) {
            // 如果当前的数字是连续序列的起点，即在该数组中 没有恰好比该起点数小1的数，开始考虑
            if (!set.contains(num - 1)) {
                int temp = 1; //如果找到一个起始点，那么得重新开始计数

                while (set.contains(++num)) temp++; // 开始统计
                ans = ans > temp ? ans : temp; // 去最大的那个
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution_128 a = new Solution_128();
        int[] nums = {100, 4, 200, 1, 3, 2};

        System.out.println(a.longestConsecutive(nums));
    }

}
