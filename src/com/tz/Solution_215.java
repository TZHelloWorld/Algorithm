package com.tz;

import java.util.PriorityQueue;

public class Solution_215 {

    // 快速排序。。。
    public int findKthLargest(int[] nums, int k) {
        return 0;
    }


    // 堆排序，找出第k个元素
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k + 1, (x, y) -> x - y);
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();

    }
}
