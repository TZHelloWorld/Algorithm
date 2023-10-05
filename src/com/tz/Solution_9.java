package com.tz;

import java.util.Arrays;

public class Solution_9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int revertedNum = 0;
        int Num = x;
        while (Num > 0) {
            revertedNum = revertedNum * 10 + Num % 10;
            Num = Num / 10;
        }

        return x == revertedNum;


    }
}
