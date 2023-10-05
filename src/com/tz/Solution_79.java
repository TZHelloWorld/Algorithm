package com.tz;

public class Solution_79 {
    public boolean exist(char[][] board, String word) {
        int cur_i = board.length, cur_j = board[0].length;
        boolean[][] visited = new boolean[cur_i][cur_j];

        // 从数组中每个结点开始遍历，查找满足条件的返回true。否则返回false
        for (int i = 0; i < cur_i; i++) {
            for (int j = 0; j < cur_j; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }

        return false;

    }

    // 设函数 check(i, j, k) 表示判断以网格的(i, j) 位置出发，能否搜索到单词 word[k..]，
    // 其中 word[k..] 表示字符串 word从第 k 个字符开始的后缀子串。如果能搜索到，则返回 truee，反之返回 false。
    public boolean check(char[][] board, boolean[][] visited, int i, int j, String word, int k) {
        // 该结点不满足后续相等的条件
        if (board[i][j] != word.charAt(k)) {
            return false;
        }
        // 查找到满足条件的 返回Ture
        if (k == word.length() - 1) {
            return true;
        }

        // 修改当前节点状态，选择进入
        visited[i][j] = true;

        // 递归查找结点(i,j)邻接点是否满足条件。 需要判断一下，
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            // 判断下一个新结点是否越界
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                // 没有越界，判断是否访问过。
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, word, k + 1);
                    if (flag) { //找到了一个就可以返回了
                        result = true;
                        break;
                    }
                }
            }
        }

        // 回溯
        visited[i][j] = false;
        return result;
    }


}
