package com.tz;


import java.util.HashSet;
import java.util.Set;

// todo 这个字节挺喜欢考的。。。
// https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
public class Solution_3 {

    // 重新写一下，这个窗口尽量设置为 [left,right) 区间
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0; // 设定区间为 [left,right)，左开右闭
        Set<Character> set = new HashSet<>();
        int ans = 0;

        while (left < s.length()) {

            // 右指针移动,最终的右指针是 s.length()
            while (right < s.length() && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }

            //
            ans = Math.max(ans, right - left);

            // 左指针移动，方便查找下一个对应的右指针。
            set.remove(s.charAt(left));
            left++;


        }
        return ans;

    }
}


