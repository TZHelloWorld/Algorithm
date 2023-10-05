package com.tz;

public class Solution_91 {
    // 这个题目没规划出来，需要注意一下：
    // 对于字符串 string，将其处理为数组形式，那么就是由s[1],s[1],...,s[n] 来确定
    // 那么设 dp[i]表示字符串 s[1..i]这 i 个字符串的解码方法数。那么就需要考虑状态转移方程，
    // 进行状态转移时，我们可以考虑最后一次解码使用了 s 中的哪些字符，一般有两种情况，单字符，双字符：

    // 对于单字符，也就是最后一个解码单独使用 s[i] 来解码，那么状态判断和转移方程如下：
    // if s[i] !=0 , 也就是1~9 ，表示A~I, 那么也就有 dp[i-1] 种情况

    // 对于使用最后两个字符表示解码，即使用s[i-1,i] 来解码，那么得判断，这两个字符组成的整数必须小于等于26, 即解码为J~Z
    // 因此，有 if 10<= s[i-1]* 10 + s[i] <=26 也就有 dp[i-2] 种情况

    // 于是对于dp[i]的最终结果就由最后由双字符和单字符的数量之和决定

    // 对于边界条件，dp[0] = 1, 表示空字符串可以有 1 种解码方法，解码出一个空字符串。

    public int numDecodings(String s) {

        int n = s.length();
        int[] dp = new int[n + 1]; // 初始化全为0， 这很重要

        dp[0] = 1;// 边界条件

        for (int i = 1; i <= n; i++) {

            if (s.charAt(i-1) != '0') { // 最后为单字符的解码
                dp[i] += dp[i - 1];
            }

            // 最后字符由双字符来解码
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0')) <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];


    }

    public static void main(String[] args) {
        Solution_91 a = new Solution_91();
        String s = "223";
        System.out.println(a.numDecodings(s));

    }


}
