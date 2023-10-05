package com.tz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution_56 {

    public int[][] merge(int[][] intervals) {
        // 边界判断
        if (intervals.length == 0) {
            return new int[0][2];
        }

        // 对intervals左端点进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> merged = new ArrayList<int[]>(); // 包存最终结果用的
        for (int i = 0; i < intervals.length; i++) { // 对排序后的数组每个区间进行判断
            // 为了判断方便，获取当前判断的左端点和右端点
            int L = intervals[i][0], R = intervals[i][1];

            // 表示当前的区间与之前的区间没有重复的。那么就单独加入新的区间长度
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            }else{
                // 如果有重复的，那么将重复区间的右端点（list中最后一个）进行更新
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

}
