package com.tz;

public class Solution_200 {
    // 深度搜索算法
    public int numIslands(char[][] grid) {
        // 边界判断
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int ans = 0;// 用于记录岛屿的个数
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    ans++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return ans;

    }

    // 从i,j开始搜索
    public void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        int nr = grid.length;
        int nc = grid[0].length;

        // 边界判断,越界判断
        if (i < 0 || j < 0 || i >= nr || j >= nc) {
            return;
        }

        //
        if (grid[i][j] == '0' || (grid[i][j] == '1' && visited[i][j] == true)) {
            return;
        }

        visited[i][j] = true;
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i, j - 1);
        dfs(grid, visited, i, j + 1);
    }


}
