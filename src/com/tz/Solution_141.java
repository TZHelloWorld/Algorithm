package com.tz;

public class Solution_141 {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public boolean hasCycle(ListNode head) {
        ListNode next_node = head;
        ListNode next_node_2 = head;

        while (next_node != null && next_node_2 != null) {
            if (next_node.next == null || next_node_2.next == null || next_node_2.next.next == null) {
                return false;
            }

            next_node = next_node.next;
            next_node_2 = next_node_2.next.next;


            if (next_node == next_node_2) {
                return true;
            }

        }


        return false;

    }


}
