package com.tz;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_226 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 思路就是遍历每个结点，然后交换左右指针即可
    public TreeNode invertTree(TreeNode root) {
        TreeNode pre = root, r = null;
        Deque<TreeNode> stack = new LinkedList<>();

        while (!stack.isEmpty() || pre != null) {
            if (pre != null) {
                stack.push(pre);
                pre = pre.left;
            } else {
                pre = stack.element(); // 获得栈顶元素
                if (pre.right != null && pre.right != r) { // 右子树存在，且没被访问过
                    pre = pre.right;
                } else {
                    pre = stack.pop();
                    // 交换左右子树
                    TreeNode temp = pre.left;
                    pre.left = pre.right;
                    pre.right = temp;

                    r = pre;
                    pre = null;
                }


            }


        }

        return root;
    }

}
