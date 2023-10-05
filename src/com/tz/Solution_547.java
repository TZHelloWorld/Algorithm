package com.tz;

public class Solution_547 {
    public int findCircleNum1(int[][] isConnected) {
        int NodeNum = isConnected.length; //记录结点个数
        boolean[] visited = new boolean[NodeNum]; //用于记录各个结点是否被访问了
        int count = 0;
        for (int i = 0; i < NodeNum; i++) { //遍历所有结点
            if (!visited[i]) { //筛查去除未被访问的结点
                bfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    public void bfs(int[][] isConnected, boolean[] visited, int i) {
        visited[i] = true; //将该节点设置为true
        for (int j = 0; j < visited.length; j++) {
            // 递归遍历该节点未被访问的邻接结点。
            if (isConnected[i][j] == 1 && !visited[j]) {
                bfs(isConnected, visited, j);
            }
        }
    }
// ==================================================================

    //对于该题，看官解答有个更厉害的操作，使用并查集。。。
    //并查集的两个基础操作：Union与Find

    // 找到结点i对应的集合根节点
    public int find(int[] parent, int i) {
        if (parent[i] != i) { //不是根节点，继续查找
            return find(parent, parent[i]);
        } else {
            return parent[i];
        }
    }

    // 合并结点i和j，这里直接添加的。。
    public void union(int[] parent, int i, int j) {
        parent[find(parent, i)] = find(parent, j);
    }

    public int findCircleNum(int[][] isConnected) {
        int nodeNum = isConnected.length;
        int[] UnionFind = new int[nodeNum];

        //初始化并查集中每一个结点为一个集合
        for (int i = 0; i < nodeNum; i++) {
            UnionFind[i] = i;
        }

        //遍历数组，把相邻的结点通过并查集树合并起来
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    union(UnionFind, i, j);
                }
            }
        }

        //统计集合的个数
        int count = 0;
        for (int i = 0; i < nodeNum; i++) {
            if (UnionFind[i] == i) {
                count++;
            }
        }
        return count;
    }


}
