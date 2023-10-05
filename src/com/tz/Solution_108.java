package com.tz;

public class Solution_108 {

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

    public TreeNode sortedArrayToBST(int[] nums) {
        return recursion(nums, 0, nums.length - 1);
    }

    public TreeNode recursion(int[] nums, int left, int right) {

        if (left > right) { //边界判断
            return null;
        }

        int mid = (right + left) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = recursion(nums, left, mid - 1);
        root.right = recursion(nums, mid + 1, right);
        return root;
    }
}
