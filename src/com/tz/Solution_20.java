package com.tz;

public class Solution_20 {


    public boolean isValid(String s) {
        char[] stack = new char[s.length()]; // 创建一个栈
        int top = -1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack[++top] = ch;
            } else {
                if (top == -1) { // 栈空判断
                    return false;
                }
                char temp = stack[top--];
                if (!((ch == ')' && temp == '(') ||
                        (ch == ']' && temp == '[') ||
                        (ch == '}' && temp == '{'))) {
                    return false;
                }
            }
        }
        return top == -1; // 判断栈是否为空
    }

    public static void main(String[] args) {
        Solution_20 a = new Solution_20();
        String s = "()";
        System.out.println(a.isValid(s));
    }
}
