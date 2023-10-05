package com.tz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_46 {

    // 回溯算法

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();


        int n = nums.length;
        backtrack(n, nums, res, 0);
        return res;
    }

    public void backtrack(int n, int[] output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                result.add(output[i]);
            }
            res.add(result);
        }
        for (int i = first; i < n; i++) {
            int temp;

            // 动态维护数组
            temp = output[first];
            output[first] = output[i];
            output[i] = temp;

            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);

            // 撤销操作
            temp = output[first];
            output[first] = output[i];
            output[i] = temp;
        }
    }


    public static void main(String[] args) {
        Solution_46 a = new Solution_46();
        int[] nums = {1, 2, 3};
        System.out.println(a.permute(nums));

    }


}
