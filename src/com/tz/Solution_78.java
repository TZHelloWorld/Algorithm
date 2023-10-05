package com.tz;

import java.util.ArrayList;
import java.util.List;

public class Solution_78 {

    // 按照思路我本来想的是从0-2^(num.length)-1 遍历， 然后通过将其转换成二进制一个一个判断，位运算不太熟悉，所以使用回溯算法实现
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums);
        return ans;

    }

    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();


    public void backtrack(int cur, int[] nums) {

        // 搜索到一个可行解，然后记录该合法的答案
        if (nums.length == cur) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }

        // 考虑选择当前位置。是否考虑当前位置，是通过temp中数据的个数来写的边界条件。
        // 因此考虑与不考虑都需要调用函数。
        temp.add(nums[cur]);
        backtrack(cur + 1, nums);
        temp.remove(temp.size() - 1);

        // 考虑不选择当前位置
        backtrack(cur + 1, nums);
    }


}
