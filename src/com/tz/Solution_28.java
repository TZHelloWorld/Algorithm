package com.tz;

public class Solution_28 {

    public int strStr(String haystack, String needle) {

        for (int i = 0; i + needle.length() <= haystack.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }

            if (flag) { // 找到了，返回下标
                return i;
            }
        }
        return -1;
    }

}
