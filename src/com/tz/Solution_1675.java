package com.tz;

import java.util.TreeSet;

public class Solution_1675 {

    // 数组的 偏移量 是数组中任意两个元素之间的 最大差值

    // 该题思路：先看问题：n个 正整数 组成的 数组 nums，可以对数组的任意元素执行任意次数的两类操作：
    // 1. 如果元素是 偶数 ，除以 2
    // 2. 如果元素是 奇数 ，乘上 2

    // 考虑一下，对于操作1，如果一直是偶数，那么其执行次数可以多次，而对于操作2而言，其只能执行一次，比如说3，其只能执行操作2 (乘上 2) 然后变为6(偶数)
    // 于是乎，其只能做1的操作，只能除以21次。 那么首先就将 nums中的数据进行一次遍历，筛选出奇数，使其乘以2 变为偶数：
    // 那么就可以限定对nums中的数 只能执行任意次数的 操作1

    // 那么就需要维护一个优先队列，找到数据中的最大值和最小值，由于上述操作限定了只能执行操作1，所以一直在将最大值取出，考虑是否为偶数，然后将其除以2，去判断该操作是否能够得到 最小偏移量
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>(); // 主要是有序，而且能去重，方便使用
        for (int num : nums) {
            set.add(num % 2 == 0 ? num : num * 2); // 对奇数乘2加入set，偶数直接加入set
        }
        int res = set.last() - set.first(); // 记录此时的最大值和最小值作为初始的 最小偏移量
        while (res > 0 && set.last() % 2 == 0) {
            int max = set.last(); // 返回set中的最大整数

            // 将最大整数 (偶数，while中进行了判断) 进行删除，并除以2操作，并加入set中
            set.remove(max);
            set.add(max / 2);

            // 考虑是否更新 最小偏移量
            res = Math.min(res, set.last() - set.first());
        }
        return res;
    }

}
