package com.tz;

import java.util.ArrayList;
import java.util.List;

public class Solution_22 {
    // 题目：数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
    // 输入：n = 3
    //输出：["((()))","(()())","(())()","()(())","()()()"]

    // 一眼回溯，用递归。。。backtrack，那么传入条件有啥。主要是考虑进入以后如何考虑括号。。。

    // 这里主要是添加了一个max变量，通过传入max，最终通过左右括号数量来确定边界，当然也可以用左右剩余括号数量，俺么边界条件就是 减少到0
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;

    }

    // 该递归函数表示
    public void backtrack(List<String> ans, StringBuilder str, int left, int right, int max) {
        if (str.length() == max * 2) { // 表示当前找到一个最优解
            ans.add(str.toString());
            return;
        }

        if (left < max) { // 表示左括号数量小于n ，表示可以继续放入左括号
            str.append('(');
            backtrack(ans, str, left + 1, right, max);

            // 回退
            str.deleteCharAt(str.length() - 1);
        }

        if (left < right) { // 表示左括号数量小于右括号数量，说明可以加入右括号
            str.append(")");
            backtrack(ans, str, left, right + 1, max);
            // 回退
            str.deleteCharAt(str.length() - 1);
        }


    }


    public static void main(String[] args) {
        Solution_22 a = new Solution_22();
        System.out.println(a.generateParenthesis(3));
    }


}
