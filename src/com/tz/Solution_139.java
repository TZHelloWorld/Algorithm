package com.tz;

import java.util.HashSet;
import java.util.List;

public class Solution_139 {

    // 这个也是动态规划算法，设dp[i] 表示字符串 i 个字符组成的字符串 s[0..i−1] 是否能被空格拆分成若干个字典中出现的单词。
    // todo public String substring(int beginIndex, int endIndex)：
    //  - beginIndex -- 起始索引（包括）, 索引从 0 开始。
    //  - endIndex -- 结束索引（不包括）。


    public boolean wordBreak(String s, List<String> wordDict) {

        // 使用hashset快速定位
        HashSet<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;//找到一个即可，不用往后继续找
                }
            }
        }


        return dp[s.length()];
    }

}
