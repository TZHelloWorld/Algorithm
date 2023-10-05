package com.tz;

public class Solution_7 {

    // 弹出 x 的末尾数字 digit
    //    digit = x % 10
    //    x /= 10

    // 将数字 digit 推入 rev 末尾
    //    rev = rev * 10 + digit

    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            // 溢出判断
            if (ans < Integer.MIN_VALUE / 10 || ans > Integer.MAX_VALUE / 10) {
                return 0;
            }

            int digit = x % 10;
            x = x / 10;

            ans = ans * 10 + digit;


        }
        return ans;

    }


    public static void main(String[] args) {
        Solution_7 a = new Solution_7();
        System.out.println(a.reverse(-123));

        System.out.println(-102 % 10); // -2

    }
}
