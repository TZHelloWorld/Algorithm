package com.tz;

import java.util.ArrayDeque;
import java.util.Deque;

// todo 具体可以参考 https://leetcode.cn/problems/largest-rectangle-in-histogram/solutions/142012/bao-li-jie-fa-zhan-by-liweiwei1419/?envType=featured-list&envId=2cktkvj%3FenvType%3Dfeatured-list&envId=2cktkvj


public class Solution_84 {

    // 单调栈，注意这个思路。后面还有个哨兵的优化方法
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] left = new int[n]; // 从 0-->heights.length 进行单调栈找到左边界
        int[] right = new int[n];// 从 heights.length-->0 进行单调栈找到右边界

        Deque<Integer> mono_stack = new ArrayDeque<Integer>(); // 创建栈

        // 对数组中每个元素都进行入栈操作，然后使进入栈的大小是单调的（while操作）。
        for (int i = 0; i < n; ++i) {
            // 栈不为空，且入栈元素大于等于栈顶元素
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }

            // 出现栈
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        mono_stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }


    // 暴力方法，超时了
    public int largestRectangleArea1(int[] heights) {

        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            ans = Math.max(ans, maxArea(heights, i));
        }
        return ans;


    }


    // 以index作为矩形的最大值能计算出来的面积最大值
    public int maxArea(int[] heights, int index) {
        int height = heights[index];
        int left = index - 1, right = index + 1;

        while (left >= 0 && heights[left] >= height) {
            left--;
        }

        while (right < heights.length && heights[right] >= height) {
            right++;
        }

        return (right - left - 1) * height;

    }

}
