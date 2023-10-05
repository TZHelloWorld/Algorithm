package com.tz;

// todo 加油站题目，挺经典的，这个我自己写的话两重for循环
//  可参考 https://leetcode.cn/problems/gas-station/solutions/25644/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--30/
//  主要是 假设 a 的加油站能够到达 b，但是未能到达到b+1, 那么，容易判断 [a, b]中一个结点c，能够到达b,但是一定到达不了b+1,
//  举个例子 ,以题目为例，假设我从a 出发，到达了c后，肯定是有油的或者0， 既然我c有油都到不了 b+1,那么我从c(没油)出发,肯定也到不了 b+1.
public class Solution_134 {

    // 思路就是，从头开始遍历，假设能够从i到达最后，且从0开始到最后的剩余油量>0或者说等于0 ，则i就是, 举例来说： 这里数组用的是 nums[i] =  gas[i] - cost[i]
    // -2 -2 -2 3 3 , 这里表示油箱油拖欠
    // [-2 -2 -2 3 3] [-2 -2 -2 3]
    //         |           |

    //将数组复制一遍，然后类似于遍历，判断长度为n的固定窗口中，判断是否可达，如果不可达，将窗口起始点设置为不可达的索引下
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total = 0;
        int index = -1;
        int i = 0;
        while (i < n) {
            int current = 0; // 考虑从0开始出发，当前油量
            int j = 0;
            while (i + j < n) {
                current += gas[i + j] - cost[i + j];
                total += gas[i + j] - cost[i + j];

                if (current < 0) { // 不可达,跳过后序遍历
                    break;
                }
                j++;
            }
            if (i + j == n) { // 找到可行解
                index = i;
                break;
            } else {  // 更新左指针
                i = i + j + 1;
            }
        }

        if (total >= 0) return index;
        else return -1;


    }


    public static void main(String[] args) {
        Solution_134 a = new Solution_134();
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(a.canCompleteCircuit(gas, cost));
        ;
    }
}
