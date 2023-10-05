package com.tz;

public class Solution_21 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode prehead = new ListNode(-1); // 创建一个空的头结点，方便后续操作

        ListNode pre = prehead;


        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                pre.next = list2;
                list2 = list2.next;
            } else {
                pre.next = list1;
                list1 = list1.next;
            }
            pre = pre.next;
        }
        //  遍历完成后，会出现一种一条null，一条不为null的
        if (list1 == null) {
            pre.next = list2;
        }
        if (list2 == null) {
            pre.next = list1;
        }
        return prehead.next;
    }
}
