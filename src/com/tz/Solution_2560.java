package com.tz;

// todo 打家劫舍 ，主要是这个二分查找比较强，虽然会二分，但是证明可行性比较难以想通
//  这个题目就是假设一个解，然后判断该解是否正确 ，如果不正确，然后假设另一个解，继续判断是否正确。
//  只不过在假设解的可能性的时候使用了二分的方式
//  还有一个点就是判断该解是否正确

import java.util.PriorityQueue;

public class Solution_2560 {

    public int minCapability(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
        }

        while (!queue.isEmpty()) {
            int i = queue.poll();
            int f0 = 0, f1 = 0;
            for (int x : nums)
                if (x > i) f0 = f1;
                else {
                    int tmp = f1;
                    f1 = Math.max(f1, f0 + 1);
                    f0 = tmp;
                }

            if (f1 == k) return i;
        }


        return -1; // 没有满足条件的
    }



}
