package com.tz;

public class Solution_130 {

    // 这个题目还是挺有意思的，反过来想，找包围的不好找，那么找不被包围的是不是很容易
    // 也就是找与边界上的 o 相连接的是不需要被填充的，其他的是需要被填充的。
    // 那么 与边界上的o直接或者间接连接的就是不需要改变的，其他的则是需要改变的，那么在遍历过程中，将未被包围的设置为 U，
    // 那么结束遍历后则将数组中为改变的设置为x，U设置为o（这个设定有意思，本来需要一个visited数组的，不过这里可以减少开销）
    public void solve(char[][] board) {
        // 第一行和最后一行的o遍历
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }

        // 第一列与最后一列的o的遍历
        for (int i = 0; i < board[0].length; i++) {
            dfs(board, 0, i);
            dfs(board, board.length - 1, i);
        }

        // 遍历完后统计哪些被设置为了U ，将其改为o，其他的o改为x
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'U') {
                    board[i][j] = 'O';
                }
            }
        }


    }

    public void dfs(char[][] board, int x, int y) {

        //
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'O') {
            return;
        }

        board[x][y] = 'U';
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }

}
