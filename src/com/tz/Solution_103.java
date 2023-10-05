package com.tz;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution_103 {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }


        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // 用于记录从level头插还是尾插
        boolean isOrderLeft = true;

        while (!queue.isEmpty()) {
            Deque<Integer> level = new LinkedList<>();


            // 此时队列中有多少个数据，即表示该层有多少个元素
            int n = queue.size();

            for (int i = 0; i < n; i++) {

                root = queue.remove();

                // 添加
                if (isOrderLeft) {
                    level.addLast(root.val);
                } else {
                    level.addFirst(root.val);
                }

                // 将队列数据加入
                if (root.left != null) {
                    queue.add(root.left);
                }

                if (root.right != null) {
                    queue.add(root.right);
                }
            }

            ans.add(new LinkedList<Integer>(level));
            isOrderLeft = !isOrderLeft;
        }

        return ans;
    }

}
