package com.tz;

public class Solution_10 {

    // 是一个「逐步匹配」的过程：我们每次从字符串 p 中取出一个字符或者「字符 + 星号」的组合，并在 s 中进行匹配。
    // 主要匹配的是 * （匹配零个或多个前面的那一个元素）和 . (匹配任意单个字符)

    // 设dp[i][j] 表示 s 的前 i 个字符与 p 中的前 j 个字符是否能够匹配。在进行状态转移时，我们考虑 p 的第 j 个字符的匹配情况:
    // 那么问题就是，对于dp[i][j]之前的已知，如何求解dp[i][j]问题
    // 那就逐个逐个考虑：
    //      考虑最简单的 p[j] == s[i] , 那么 dp[i][j] = dp[i-1][j-1];
    //      然后从 p[j] 可能的情况来考虑，比如说 . * 以及 p[j] != s[i] // https://leetcode.cn/problems/regular-expression-matching/solution/by-flix-musv/
    // 那么如果 p[j] == '.' 那么 dp[i][j] = dp[i-1][j-1]
    // 如果 p[j] == '*', 这个分析比较复杂，因为得考虑* 匹配多少次，如果可能的话，匹配 0~k个的匹配。
    // 这里举例说明比较容易： s = abaaacd , p = aba*cd
    // 对于匹配0次情况， dp[i][j] = dp[i][j-2] // 这里的j-2 表示说明的是最后类似于 'a*'两个字符不考虑(因为匹配0次情况)
    // 对于匹配1次情况， dp[i][j] = dp[i-1][j-2] ，并且是满足 s[i] = p[j-1]  , 比如说 aba 匹配 aba*
    // 对于匹配2次情况， dp[i][j] = dp[i-2][j-2] ，并且是满足 s[i] = s[i-1] = p[j-1]  , 比如说 abaa 匹配 aba*
    // 对于匹配3次情况， dp[i][j] = dp[i-3][j-2] ，并且是满足 s[i] = s[i-1] = s[i-2] = p[j-1]  , 比如说 abaaa 匹配 aba*
    // ...
    // 那么对于k次匹配，可以找出规律 dp[i][j] = dp[i-k][j-2] ,此时需要满足 s[i] = s[i-1] ... = s[i-k+1] = p[j-1]

    // 在状态转移情况中，如果满足上述任意一种，那就说明匹配。。
    // 即 dp[i][j] = dp[i][j-2] or (dp[i-1][j-2] & s[i] = p[j-1]) or ( dp[i-2][j-2] & (s[i] = s[i-1] = p[j-1])) ... or (dp[i-k][j-2] & (s[i] = s[i-1] ... = s[i-k+1] = p[j-1]))
    // 同理写出 dp[i-1][j] ,然后替换上面的后半部分，可以得出：
    // dp[i][j] = dp[i][j-2] or dp[i-1][j]

    /**************************************************
     总结起来，状态转移方程就是：
     if s[i] = p[j], dp[i][j] = dp[i-1][j-1]
     if p[j] = '.', dp[i][j] = dp[i-1][j-1]
     if p[j] = '*',
     if s[i] != p[j-1], dp[i][j] = dp[i][j-2] (只能是匹配0次的情况才能匹配)
     if s[i] == p[j-1], dp[i][j] = dp[i][j-2] or dp[i-1][j] (来自于递推的状态转移)
     ***************************************************/

    // 然后考虑边界套件，即初始化
    // dp[0][0] = true，表示两个中都取0是可以匹配的。
    // 那么对于dp[i][0], false
    // 对于dp[0][j] ,需要考虑一下情况，因为有种情况 “” 和 “a*”，“a*b*”，“c*d*”情况其实是匹配的，所以
    // if p[j] != '*', 不考虑，false
    // if p[j] == '*', 则有 dp[0][j]=dp[0][j−2]
    public boolean isMatch(String s, String p) {

        int m = s.length(), n = p.length();
        // 创建dp数组
        boolean[][] dp = new boolean[m + 1][n + 1]; // 默认就是false, 所以不需要赋值 dp[i][0]

        // 边界
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }


        // 状态转移
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 考虑s最后一个等于p最后一个情况
                if (s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // 考虑p最后一个是 .
                if (p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                // 考虑 p 最后一个是 *
                // 可能情况有 "a*" 或者 ".*"
                if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    }
                }

            }
        }


        return dp[m][n];
    }
}
