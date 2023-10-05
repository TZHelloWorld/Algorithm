package com.tz;

public class Solution_437 {
    public int pathSum(TreeNode root, int targetSum) {
        // 边界判断
        if (root == null) {
            return 0;
        }

        int ans = rootSum(root, targetSum);
        ans += pathSum(root.left, targetSum);
        ans += pathSum(root.right, targetSum);
        return ans;
    }


    // 定义 rootSum(p,val) 表示以节点 ppp 为起点向下且满足路径总和为 val 的路径数目。
    public int rootSum(TreeNode root, int targetSum) {
        int num = 0; // 用于统计对应的路径数目

        if (root == null) {
            return 0;
        }
        if (root.val == targetSum) {
            num++;
        }

        // 递归调用左，右子树
        num += rootSum(root.left, targetSum - root.val);
        num += rootSum(root.right, targetSum - root.val);


        return num;

    }


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

}
