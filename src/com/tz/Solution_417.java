package com.tz;

import java.util.ArrayList;
import java.util.List;

public class Solution_417 {
    // 这个题目一开始没怎么看懂，不过多看看题目介绍就能懂了，而且这个思路也挺有意思的。强烈推荐直接看解析。

    //反向搜索 这个操作挺可以，不过边界需要注意，也就是在搜索过程中需要记录每个单元格是否可以从太平洋反向到达以及是否可以从大西洋反向到达。

    // 反向搜索过程中国，记录每个单元格反向到达是否达到，在选择邻接点的时候判断。通过关键字高度。

    int[][] heights;
    int m, n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;

        boolean[][] pacific = new boolean[m][n]; // 用于记录能流向太平洋的
        boolean[][] atlantic = new boolean[m][n]; // 用于记录能流向大西洋的

        // 从四条边界开始反向搜索。
        for (int i = 0; i < m; i++) {
            dfs(pacific, i, 0);
        }
        for (int j = 1; j < n; j++) {
            dfs(pacific, 0, j);
        }
        for (int i = 0; i < m; i++) {
            dfs(atlantic, i, n - 1);
        }
        for (int j = 0; j < n - 1; j++) {
            dfs(atlantic, m - 1, j);
        }

        //统计两个集合的交集
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {  // 表示既能流向太平洋又能流向大西洋的加入集合中
                    List<Integer> cell = new ArrayList<Integer>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }
        return result;
    }

    // 从第 i，j个结点处开始遍历
    public void dfs(boolean[][] ocean, int i, int j) {
        if (ocean[i][j]) return; // 边界

        //设置该节点为被访问过
        ocean[i][j] = true;

        //访问北
        if (j - 1 >= 0 && heights[i][j - 1] >= heights[i][j]) {
            dfs(ocean, i, j - 1);
        }

        // 访问南
        if (j + 1 < n && heights[i][j + 1] >= heights[i][j]) {
            dfs(ocean, i, j + 1);
        }

        // 访问东
        if (i + 1 < m && heights[i + 1][j] >= heights[i][j]) {
            dfs(ocean, i + 1, j);
        }

        // 访问西
        if (i - 1 >= 0 && heights[i - 1][j] >= heights[i][j]) {
            dfs(ocean, i - 1, j);
        }

    }

    public static void main(String[] args) {
//        int[][] heights = {{1, 1}, {1, 1}, {1, 1}};

        int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};

        Solution_417 a = new Solution_417();

        System.out.println(a.pacificAtlantic(heights));
        ;


    }
}
