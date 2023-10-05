package com.tz;

import java.util.Scanner;


public class Solution_160 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

    }
    // 这个题目有点意思的，主要是假设 一条路的 相交前结点个数为 a ，后面个数为 c，另一条路为b, c
    // 那么主要是 考虑 路 1 走 a + c, 走到结尾后 ，将指针指向 路2, 那么走 b
    //          考虑 路 2 走 b + c, 走到结尾后 ，将指针指向 路1, 那么走 a

    // 基于此，可以找到对应的相交结点，但是有个问题，对于没有相交结点的怎么判断，代码容易写，但是不够美，参考官网的

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 边界判断
        if (headA == null || headB == null) return null;

        ListNode preA = headA, preB = headB;

        while (preA != preB) {
            preA = preA == null ? headB : preA.next; // 判断有没有走到底，如果走到底，那么走另一条路
            preB = preB == null ? headA : preB.next;
        }
        return preA;
    }

    public static void main(String[] args) {
        Solution_160 a = new Solution_160();
        Scanner input = new Scanner(System.in);

        int intersectVal = input.nextInt(); // 输入的数据


//        System.out.print("输入第一个数组的个数：");
        int m = input.nextInt();
//        System.out.println("输入第一个数组中的数据");
        ListNode listA = new ListNode(-1), a_pre = listA;

        ListNode node_a_b = null;
        for (int i = 0; i < m; i++) {
            int number = input.nextInt();
            a_pre.next = new ListNode(number);
            if (number == intersectVal) {
                node_a_b = a_pre.next;
            }


            a_pre = a_pre.next;
        }


//        System.out.print("输入第2个数组的个数：");
        int n = input.nextInt();
//        System.out.println("输入第2个数组中的数据");
        ListNode listB = new ListNode(-1), b_pre = listB;
        for (int i = 0; i < m; i++) {
            int number = input.nextInt();
            if (number == intersectVal) {
                b_pre.next = node_a_b;
                break;
            }

            b_pre.next = new ListNode(number);
            b_pre = b_pre.next;
        }


        ListNode ans = a.getIntersectionNode(listA.next, listB.next);

        System.out.println(ans.val);

//        输入第一个数组的个数：5
//        输入第一个数组中的数据
//        4 1 8 4 5
//        输入第2个数组的个数：6
//        输入第2个数组中的数据
//        5 6 1 8 4 5

        //去掉提示的输入：
        /*****
         8
         5
         4 1 8 4 5
         6
         5 6 1 8 4 5
        ******/
    }


}