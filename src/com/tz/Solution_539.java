package com.tz;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Solution_539 {
    // 主要思想就是将分钟数进行排序，然后最小时间差一般是最近的那个，那么遍历即可，不过得注意一下，最小和最大之间额最小时间差
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);// 对timepoints进行排序
        int ans = Integer.MAX_VALUE;
        int t0Minutes = getMinutes(timePoints.get(0));
        int preMinutes = t0Minutes;
        for (int i = 1; i < timePoints.size(); i++) {
            int minutes = getMinutes(timePoints.get(i));
            ans = Math.min(ans, minutes - preMinutes);
            preMinutes = minutes;
        }

        // 考虑最后一个和第一个的
        ans = Math.min(ans, t0Minutes + 1440 - preMinutes);
        return ans;
    }

    // 将string 类型转换为int类型的分钟,格式为:"23:59"
    public int getMinutes(String t) {
        return ((t.charAt(0) - '0') * 10 + (t.charAt(1) - '0')) * 60 + (t.charAt(3) - '0') * 10 + (t.charAt(4) - '0');
    }

    public static void main(String[] args) {
//        Solution_539 a = new Solution_539();
//        System.out.println(a.getMinutes("01:59"));
    }


}
