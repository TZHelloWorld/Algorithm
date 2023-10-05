package com.tz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_17 {

    //输入：digits = "23"
    //输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) return ans;

        String[] phoneMap = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


        backtrack(ans, phoneMap, digits, 0, new StringBuilder());

        return ans;
    }

    private void backtrack(List<String> ans, String[] phoneMap, String digits, int index, StringBuilder str) {
        if (digits.length() == index) { // 找到一个最优解
            ans.add(str.toString());
            return;
        }
        // 考虑当前数字
        char digit = digits.charAt(index);

        // 当前数字能够考虑的字母
        String letters = phoneMap[digit - '2'];

        for (int i = 0; i < letters.length(); i++) {
            str.append(letters.charAt(i));
            backtrack(ans, phoneMap, digits, index + 1, str);
            str.deleteCharAt(str.length() - 1); // 回退
        }
    }
}
