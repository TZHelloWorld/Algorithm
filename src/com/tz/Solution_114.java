package com.tz;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution_114 {
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


    public void flatten(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<TreeNode> list = new ArrayList<TreeNode>();


        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                list.add(root);

                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }

        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }

    }

}
