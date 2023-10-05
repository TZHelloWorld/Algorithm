package com.tz;

public class Solution_2 {

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1), tail = head; // 创建一个无效的空头结点


        int carry = 0; // 两数相加的进位
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0; // 得判断一下是否为空，并取出该值
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry; // 考虑进位并计算值

            // 创建结点并添加该节点
            tail.next = new ListNode(sum % 10);
            tail = tail.next;

            // 计算下一个该计算的结点。
            carry = sum / 10;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) { // 最后两个数字是否能进位，能就创建一个结点
            tail.next = new ListNode(carry);
        }
        return head.next;
    }


}
