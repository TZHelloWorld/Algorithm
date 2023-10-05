package com.tz;

public class Solution_26 {

    // 双指针，slow用于记录不重复的数字位置，fast用于排除掉重复的
    // 从下标为1开始，因为0没必要，重复了
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
//        if (n == 0) { // 边界判断，不需要，因为题目已有提示
//            return 0;
//        }

        int slow = 1, fast = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;

        }
        return slow;
    }
}
