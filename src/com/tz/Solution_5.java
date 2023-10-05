package com.tz;

public class Solution_5 {

    //给你一个字符串 s，找到 s 中最长的回文子串。
    //
    //如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
    //
    //

    public String longestPalindrome(String s) {

        // 边界判断
        if (s == null) {
            return "";
        }
        if (s.length() <= 1) {
            return s;
        }

        int start = 0;
        int maxLen = 1;
        for (int i = 0; i < s.length(); i++) {
            int oddLen = expandAroundCenter(s, i, i);
            int evenLen = expandAroundCenter(s, i, i + 1);
            int curMathLen = Math.max(oddLen, evenLen);

            if (curMathLen > maxLen) {
                maxLen = curMathLen;
                start = i - (curMathLen - 1) / 2;
            }

        }

        return s.substring(start, start + maxLen);
    }


    // 用于返回以[left,right]作为中心点开始向两边扩散的时候，最长的回文串长度
    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1; // 得考虑此时的right 指针与 left指针位置
    }

}
