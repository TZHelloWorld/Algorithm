package com.tz;

public class Solution_695 {

    // 递归函数用于实现：计算地图上坐标为(cur_i,cur_j)地图块连接的最大区域
    public int dfs(int[][] grid, int cur_i, int cur_j) {

        // 边界条件，超出了地图范围，返回0
        if (cur_i < 0 || cur_j < 0 || cur_i == grid.length || cur_j == grid[0].length) {
            return 0;
        }

        // 该土地已经被访问了,说明与该土地连接的区域以及被计算了，后面不需要计算，所以返回0
        if (grid[cur_i][cur_j] == 0) {
            return 0;
        }


        // 如果不满足上述两种情况，则将该土地设置为被访问过
        grid[cur_i][cur_j] = 0;

        //此时，对于该土地连接的区域计算可以包括 其左右上下四个的连接区域的计算
        return 1 + dfs(grid, cur_i - 1, cur_j) //左
                + dfs(grid, cur_i + 1, cur_j) // 右
                + dfs(grid, cur_i, cur_j - 1) // 上
                + dfs(grid, cur_i, cur_j + 1); // 下
    }


    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        // 遍历每个结点所对应的土地快，选出最大的那个地图块
        for (int i = 0; i != grid.length; ++i) {
            for (int j = 0; j != grid[0].length; ++j) {
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }

}
