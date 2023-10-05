package com.tz;

public class Solution_73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] col = new boolean[m];
        boolean[] row = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    col[i] = true;
                    row[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (col[i] || row[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
