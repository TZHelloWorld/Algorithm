package com.tz;

import java.util.*;

public class Solution_51 {

    // set 集合保存的是无序的，不重复的数据
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<List<String>>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions;
    }


    //    backtrack
    // 为了判断一个位置所在的列和两条斜线上是否已经有皇后，使用三个集合columns 、diagonals1 和 diagonals2
    // 分别记录每一列以及两个方向的每条斜线上是否有皇后
    // 其中，diagonals1 表示从左上到右下方向， diagonals2 表示从右上到左下方向
    public void backtrack(List<List<String>> solutions, int[] queens, int n, int row,
                          Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {

        // 如果找到可行解，则将可行解进行记录
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        // 否则查找一个可以查找到可行解的结点，并进行回溯。
        } else {
            for (int i = 0; i < n; i++) {

                //每次放置皇后时，对于每个位置判断其是否在三个集合中，如果三个集合都不包含当前位置，则当前位置是可以放置皇后的位置。
                if (columns.contains(i)) {
                    continue;
                }

                // 同一条斜线上的每个位置满足行下标与列下标之差相等
                int diagonal1 = row - i;  // 行下表与列下标相减，判断是否已经存入到集合中，如果没在集合中，则表示没有处在从左上到右下方向的斜线上
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }

                // 同一条斜线上的每个位置满足行下标与列下标之和相等
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }

                // 修改当前节点状态
                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);

                // 递归子节点
                backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);

                // 回改当前节点状态进行回溯
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);

            }
        }
    }


    // 将数组中queens中每个对应的皇后所在的索引设置为Q，其他设置为 . 。
    public List<String> generateBoard(int[] queens, int n) {

        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }


}
