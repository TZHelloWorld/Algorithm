package com.tz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_77 {

    // 这个题目还是比较有意思的，主要是他的思想，注意最简单的回溯算法流程，以及剪枝操作怎么实现。
    // 主要是在考虑算法的时候需要注意如何确定选择与不选择的操作
    // 为了方便记录被选出的可能组合，因此需要一个数组变量来保存数据。
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        backtrackRec(1, n, k);
        return ans;
    }

    public void backtrackRec(int cur, int n, int k) {
        // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        // 搜索到一个可行解，然后记录该合法的答案
        if (temp.size() == k) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }

        // 考虑选择当前位置。是否考虑当前位置，是通过temp中数据的个数来写的边界条件。
        // 因此考虑与不考虑都需要调用函数。
        temp.add(cur);
        backtrackRec(cur + 1, n, k);
        temp.remove(temp.size() - 1);

        // 考虑不选择当前位置
        backtrackRec(cur + 1, n, k);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("【输入】");
        System.out.print("input a number for n：");
        int n = scanner.nextInt();
        System.out.print("input a number for k：");
        int k = scanner.nextInt();

        Solution_77 a = new Solution_77();
        System.out.println("【输出】");
        System.out.println(a.combine(n, k));

    }


}
