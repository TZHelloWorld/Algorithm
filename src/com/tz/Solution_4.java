package com.tz;

public class Solution_4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans = 0;
        int m = nums1.length, n = nums2.length;
        if ((m + n) % 2 == 0) {
            ans = ((double) getNumber(nums1, nums2, (m + n) / 2) + (double) getNumber(nums1, nums2, 1 + (m + n) / 2)) / 2;
        } else {
            ans = getNumber(nums1, nums2, (m + n + 1) / 2);
        }
        return ans;
    }

    // 获得有序数组中第i大的数字
    public int getNumber(int[] nums1, int[] nums2, int target) {
        int i = 0, j = 0; // i,j 为指针

        while (i + j != target) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    i++;
                } else {
                    j++;
                }
            } else if (i >= nums1.length) {
                j++;
            } else if (j >= nums2.length) {
                i++;
            }
        }

        if (i == 0) return nums2[j - 1];
        if (j == 0) return nums1[i - 1];

        return nums1[i - 1] > nums2[j - 1] ? nums1[i - 1] : nums2[j - 1];

    }

    public static void main(String[] args) {
        Solution_4 a = new Solution_4();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
//        System.out.println(a.getNumber(nums1, nums2, 3));

        System.out.println(a.findMedianSortedArrays(nums1, nums2));
    }


}
