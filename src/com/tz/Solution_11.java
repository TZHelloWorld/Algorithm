package com.tz;

public class Solution_11 {
    // 该题使用双指针来实现，设置左右指针为 i，j，那么在移动过程中，面积计算为 min(height[i],heigth[j]) \times (j-i)
    // 那么在移动过程中，找heigth较小的那个往内部移动，然后找出最大值，
    // 这个证明其正确性看一下官网吧，有点意思的。
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, ans = 0;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, area);

            // 指针移动
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return ans;
    }
}
