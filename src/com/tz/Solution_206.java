package com.tz;

public class Solution_206 {

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


    public ListNode reverseList(ListNode head) {
        ListNode preHead = new ListNode(-1); // 哨兵结点
        ListNode temp;
        while (head != null) {
            temp = head;
            head = head.next;
            // 头插法
            temp.next = preHead.next;
            preHead.next = temp;

        }
        return preHead.next;

    }
}
