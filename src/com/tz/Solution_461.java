package com.tz;

public class Solution_461 {
    // 使用内置函数 Integer.bitCount(x ^ y)：统计一个数的二进制位有多少个 1
    // s & 1，用来取最后一位的值，与操作用来取固定区间的值，比如 1001 1100，取前 4 位 1001 1100 & 1111 0000 = 1001

    public static void main(String[] args) {

        int x = 0b10011100;//声明二进制变量
        int y = 0b11110000;//声明二进制变量

//        String s = Integer.toBinaryString(x);

        System.out.println(Integer.toBinaryString(x ^ y));
        System.out.println(Integer.toBinaryString(x ));
        System.out.println(Integer.toBinaryString(y));
    }

}
