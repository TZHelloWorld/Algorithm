package com.tz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_438 {

    /**
     * @param s string类型，
     * @param p string 类型
     * @return list类型
     */
    public List<Integer> findAnagrams1(String s, String p) {
        int s_len = s.length(), p_len = p.length();
        List<Integer> ans = new ArrayList<Integer>();//用于记录窗口滑动过程中的可行解

        //字符s的长度一定要大于字符p的长度，否则不存在异位词
        if (s_len < p_len) {
            return ans;
        }


        int[] window_count = new int[26]; //用于维护窗口滑动过程中每个字符的数量
        int[] p_count = new int[26]; //用于统计字符p的每个字符数量

        //初始统计
        for (int i = 0; i < p_len; i++) {
            window_count[s.charAt(i) - 'a']++;
            p_count[p.charAt(i) - 'a']++;
        }

        //如果窗口最初始的时候满足异位词，则将0加入到ans数组中
        if (Arrays.equals(window_count, p_count)) ans.add(0);

        //窗口开始滑动,左右都按照同频率滑动
        for (int i = 0; i < s_len - p_len; i++) {
            window_count[s.charAt(i) - 'a']--;    // 左指针移动
            window_count[s.charAt(i + p_len) - 'a']++;  // 右指针移动

            //判断是否满足异位词的条件，满足加入到ans中
            if (Arrays.equals(window_count, p_count)) ans.add(i + 1);

        }

        return ans;
    }

    /**
     * 优化滑动窗口
     *
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {

        int s_len = s.length(), p_len = p.length();
        List<Integer> ans = new ArrayList<Integer>();//用于记录窗口滑动过程中的可行解

        //字符s的长度一定要大于字符p的长度，否则不存在异位词
        if (s_len < p_len) {
            return ans;
        }

        int[] count = new int[26]; //用于维护窗口滑动过程中窗口中的字符与字符p中每个字符的差值
        int diff = 0; // 用于维护count数组中不为0的个数

        //初始统计
        for (int i = 0; i < p_len; i++) {
            count[s.charAt(i) - 'a']++;
            count[p.charAt(i) - 'a']--;
        }

        // 统计count数组中不为0的个数，并赋值给diff
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) diff++;
        }

        //如果窗口最初始的时候满足异位词，则将0加入到ans数组中
        if (diff == 0) ans.add(0);

        //窗口开始滑动,左右都按照同频率滑动
        for (int i = 0; i < s_len - p_len; i++) {
            //左指针移动导致diff变化的情况
            if (count[s.charAt(i) - 'a'] == 1) {
                diff--;
            } else if (count[s.charAt(i) - 'a'] == 0) {
                diff++;
            }
            count[s.charAt(i) - 'a']--;    // 左指针移动

            //右指针移动导致diff变化的情况
            if (count[s.charAt(i + p_len) - 'a'] == -1) {
                diff--;
            } else if (count[s.charAt(i + p_len) - 'a'] == 0) {
                diff++;
            }
            count[s.charAt(i + p_len) - 'a']++;  // 右指针移动

            //判断是否满足异位词的条件，满足加入到ans中
            if (diff == 0) ans.add(i + 1);

        }

        return ans;
    }


    public static void main(String[] args) {

        String s = "abbcbab";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }

}
