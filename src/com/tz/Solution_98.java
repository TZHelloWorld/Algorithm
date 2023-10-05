package com.tz;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_98 {


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

    // 这个思想很有意思，一开始想不到，主要是 isValidBST这个函数可以，函数表示考虑以 root 为根的子树，判断子树中所有节点的值是否都在(lower,upper) 这个范围内
    // 这样就可以避免掉指针的判断，因为要判断左右指针的话会很麻烦。
    public boolean isValidBST1(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

    // 或者模拟中序遍历，其中序遍历是有序数组，所以。。
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;


            root = root.right;

        }

        return true;
    }


}
