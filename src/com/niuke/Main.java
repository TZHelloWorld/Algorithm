package com.niuke;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        BigInteger[] data = new BigInteger[n];
        for (int i = 0; i < n; i++) {
            data[i] = in.nextBigInteger();
        }

        int count = 0;// 用于统计满足a[i]<n的个数
        int k = 0;

        while (count != n) {
            int max_index = 0;
            // 每次操作,选出最大的数下标
            for (int i = 0; i < n; i++) {
                if (data[i].compareTo(data[max_index]) == 1) {
                    max_index = i;
                }
            }
            count = 0;
            for (int i = 0; i < n; i++) {
                if (i == max_index) {
                    data[i] = data[i].subtract(BigInteger.valueOf(n));
                }
                data[i].subtract(BigInteger.valueOf(1));
                if (data[i].compareTo(BigInteger.valueOf(n)) == -1) {
                    count++;
                }
            }
            k++;

        }
        System.out.println(k);
    }
}
