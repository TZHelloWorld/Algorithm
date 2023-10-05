package com.tz;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_150 {

    // 逆波兰表达式求值就是一个堆栈的问题，遇到数字就进栈，遇到符号，弹出两个栈，然后求值

    public int evalRPN(String[] tokens) {

        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < tokens.length; i++) {
            if ("+".equals(tokens[i])) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 + num1);
            } else if ("-".equals(tokens[i])) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 - num1);
            } else if ("*".equals(tokens[i])) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 * num1);
            } else if ("/".equals(tokens[i])) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 / num1);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }

        }
        return stack.pop();
    }

}
