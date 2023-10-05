package com.tz;

public class Solution_19 {
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

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode first = head, second = new ListNode(0, head);
            for (int i = 0; i < n; i++) {
                first = first.next;
            }

            while (first!= null) {
                first = first.next;
                second = second.next;
            }

            second.next = second.next.next;// 删除该结点
            return head;
        }
    }

}
