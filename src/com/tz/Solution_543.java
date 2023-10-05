package com.tz;

public class Solution_543 {
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


    public int diameterOfBinaryTree(TreeNode root) {
        recursion(root);
        return ans;
    }

    int ans = 0;

    // 计算出左子树与右子树的最长高度之和+1
    public int recursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recursion(root.left);
        int right = recursion(root.right);

        // 更新最终答案
        ans = Math.max(ans, left + right+1);

        return Math.max(left, right) ; // 返回左右子树中最大

    }

}
