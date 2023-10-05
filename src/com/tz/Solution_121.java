package com.tz;

public class Solution_121 {


    // 买卖股票 I，只能买卖一支股票

    // 一种是暴力破解方法，这种时间复杂度是o(n*n)
    // 第二种，只需要遍历价格数组一遍，记录历史最低点，然后在每一天考虑这么一个问题：如果我是在历史最低点买进的，那么我今天卖出能赚多少钱？
    public int maxProfit121(int[] prices) {

        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];  // 记录历史最低点
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice; //每一天考虑赚最多的钱
            }
        }
        return maxprofit;
    }


    // 买卖股票II，题目122
    // 贪心思想，只要第二天的价格比前一天的加个高，那么就有的赚，于是：
    public int maxProfit122(int[] prices) {

        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
//            if (prices[i] > prices[i - 1]) {
//                ans += prices[i] - prices[i - 1];
//            }
            // 这里可以优化一下
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;

    }

    // 买卖股票III，题目123
    //设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
    // 这个设计比较牛皮，直接看官方解析比较好
    // 主要是:由于我们最多可以完成两笔交易，因此在任意一天结束之后，我们会处于以下五个状态中的一种：
    //      1.未进行过任何操作；由于该状态的利润显然为0，无需记录
    //      2.只进行过一次买操作；使用 buy1 来存储
    //      3.进行了一次买操作和一次卖操作，即完成了一笔交易；使用 sell1 来存储
    //      4.在完成了一笔交易的前提下，进行了第二次买操作；使用 buy2 来存储
    //      5.完成了全部两笔交易。使用 sell2 来存储

    // 那么考虑状态转移方程：也就是buy1 选第一个最低点买入，sell1表示选一个比较高的点卖
    // buy2 和sell2 同理，不过有个问题，怎么保证sell1在buy2之前执行。。这个没搞明白。。

    public int maxProfit123(int[] prices) {
        int n = prices.length;
        int buy1 = prices[0], sell1 = 0;
        int buy2 = prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i] - buy1);
            buy2 = Math.min(buy2, prices[i] - sell1);
            sell2 = Math.max(sell2, prices[i] - buy2);
        }
        return sell2;
    }


    // todo 买卖股票IV，题目188
    public int maxProfit(int k, int[] prices) {
        return 0;
    }
}
