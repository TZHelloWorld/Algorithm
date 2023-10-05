package com.tz;


import java.util.*;

public class Solution_23 {

    public static class ListNode {
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

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode list : lists) {
            while (list != null) {
                queue.add(list);
                list = list.next;
            }
        }

        ListNode ans = new ListNode(-1);// 头结点
        ListNode pre = ans, temp;


        while (!queue.isEmpty()) {
            pre.next = queue.remove();
            pre = pre.next;
        }
        // 为保证最后一个元素的结尾为null
        pre.next = null;

        return ans.next;

    }


    // 优先队列出现循环，所以需要debug，主要是由于最后一个元素导致的。
    public static void main(String[] args) {

        Solution_23 a = new Solution_23();

        // [[-2,-1,-1,-1],[]]
        ListNode[] lists = new ListNode[2];
        ListNode list1 = new ListNode(-2);
        list1.next = new ListNode(-1);
        list1.next.next = new ListNode(-1);
        list1.next.next.next = new ListNode(-1);
        lists[0] = list1;
        lists[1] = null;


        a.mergeKLists(lists);
    }

    // 分治思想
    // 先考虑两个链表合并的，然后对于数组 [0,length-1]进行二分而治
    public ListNode mergeTwoLists(ListNode a, ListNode b) {

        // 除此之外进行减枝处理
        if (a == null || b == null) {
            return a != null ? a : b;
        }

        //为了方便对null进行处理，所以创建一个头结点
        ListNode head = new ListNode(-1);

        // 创建用于处理三条链表当前处理所指向的指针
        ListNode mainPtr = head, aPtr = a, bPtr = b;

        while (aPtr != null && bPtr != null) {
            if (aPtr.val > bPtr.val) {
                mainPtr.next = bPtr;
                bPtr = bPtr.next;
            } else {
                mainPtr.next = aPtr;
                aPtr = aPtr.next;
            }
            mainPtr = mainPtr.next;
        }

        // 处理完成以后可能有单链有多
        mainPtr.next = (aPtr == null ? bPtr : aPtr);

        return head.next;
    }

    // 对数组中进行分治处理
    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1; // 除二操作

        Arrays.sort(new int[]{1, 2, 34});

        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));

    }

    // 主函数  return merge(lists, 0, lists.length - 1);


}
