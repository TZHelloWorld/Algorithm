package com.tz;

public class Solution_72 {

    // 编辑距离，这个刚开始看比较复杂，但是一步一步来还是很容易理解的（每次状态转移只考虑一个编辑距离），
    // 假设两个字符串：word1，word2.那么设dp[i][j] 表示word1[1,..,i] 和word2[1,..,j]最小的编辑距离。
    // 这个有个不太好理解的点就是，对字符串的操作是在末尾插入或者修改字符的，这和在其它的地方进行操作是一样的，这点很重要

    // 比如说，cat -->cdab 这个操作，其实在状态转移过程中，由于index是从0开始扫描的，
    // 所以如果是在字符串中插入的话，也就是在对应的index进行扫描，具体的可以看看代码实现。

    // 于是考虑状态转移方程：
    // 如果 word1[i] == word2[j],需要考虑：在字符串末尾 添加，修改，删除,包括对word1，word2的三种操作，所以是六种，不过有等价情况：
    // 那么最小的编辑距离也就是下述的几种情况执行一个：
    //      对word1末尾添加1个字符 (对word2末尾删除一个字符)： dp[i][j] = dp[i][j-1] + 1
    //      对word1末尾进行修改 (对word2末尾进行修改)：dp[i][j] = dp[i-1][j-1]，由于相等，所以可以先不考虑
    //      对word1末尾进行删除 (对word2末尾添加一个字符)： dp[i][j] = dp[i-1][j] + 1
    //
    // 如果 word1[i] != word2[j]，同理
    //      对word1末尾添加1个字符 (对word2末尾删除一个字符)： dp[i][j] = dp[i][j-1] + 1
    //      对word1末尾进行修改 (对word2末尾进行修改)：dp[i][j] = dp[i-1][j-1]+1，由于不相等，所以需要加上修改的那个编辑距离
    //      对word1末尾进行删除 (对word2末尾添加一个字符)： dp[i][j] = dp[i-1][j] + 1


    // 考虑边界条件：
    // 对于dp[i][0], 表示的是由i个字符的变为空字符的，那最小操作数是添加i个，即 dp[i][0] = i
    // 以及dp[0][j],  表示的是由空字符变为 j个字符的， 那么dp[0][j] = j

    public int minDistance(String word1, String word2) {
        // 设 dp[i][j] 表示word1 前i个与 word2 前i个之间的编辑距离
        int m = word1.length(), n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;// 由于状态转移方程取值是取最小的，所以需要初始化为最大。
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }


        return dp[m][n];
    }


}
