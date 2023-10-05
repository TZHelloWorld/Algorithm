package com.tz;

public class Solution_88 {

    // 双指针算法，不过得从数组最后开始。因为得存入到nums1中
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int p_data = nums1.length - 1; // 用于指向数据的指针

        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                nums1[p_data] = nums2[p2--];
            } else if (p2 == -1) {
                nums1[p_data] = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                nums1[p_data] = nums1[p1--];
            } else {
                nums1[p_data] = nums2[p2--];
            }
            p_data--;
        }
    }

}
