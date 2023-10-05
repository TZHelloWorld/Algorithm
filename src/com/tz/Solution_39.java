package com.tz;

import java.util.ArrayList;
import java.util.List;

// 一眼深度搜索
// 开始的时候陷入了一个误区，就是说在考虑选择数的时候，总想着遍历数组，也就是有n个数可以选， 但其实应该是对每个数都考虑选和不选，
// 然后选了以后可以下一轮继续选这个数，这样在考虑解的时候就不会因为顺序问题而找到重复解。
public class Solution_39 {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0);
        return ans;

    }


    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> temp = new ArrayList<Integer>();

    public void dfs(int[] candidates, int target, int idx) {
        if (idx == candidates.length) {// 找到最后一个数都没找到解，则返回
            return;
        }

        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        // 不考虑当前的idx
        dfs(candidates, target, idx + 1);

        // 考虑 idx对应的值
        if (target - candidates[idx] >= 0) {
            temp.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], idx);
            temp.remove(temp.size() - 1);
        }


    }
}
