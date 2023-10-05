package com.tz;

public class Solution_66 {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10; // 怕有个数字为9的情况
            if (digits[i] != 0) return digits; // 也就是进位结束。
        }

        // 当到这里说明，digits全是9,因此返回 1000000，digits.length个0
        int[] nums = new int[digits.length + 1];
        nums[0] = 1;
        return nums;

    }
}
