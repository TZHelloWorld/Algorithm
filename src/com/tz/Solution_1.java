package com.tz;

import java.util.HashMap;

/**
 * @author tz
 * @version 1.0
 * @date 2023/10/1 23:33
 * @description:
 */
public class Solution_1 {


    // 通过hash来寻找nums[j]来提高速度
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>(); // key，value形式如 nums[j] j
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return new int[0];

    }

    /**
     * @description: 暴力破解
     * @param: nums
     * @param: target
     * @return: int[]
     * @author tz
     * @date: 2023/10/1 23:35
     */
    public int[] twoSum1(int[] nums, int target) {

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[0];
    }


}
