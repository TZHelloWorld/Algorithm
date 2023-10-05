package com.tz;

public class Solution_124 {
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


    int maxSum = Integer.MIN_VALUE; // 用于保存最终答案，因为java中没得地址传入，所以只能用成员变量来代替全局变量

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    //最大贡献值表示以该节点为根节点的子树中寻找以该节点为起点的一条路径，使得该路径上的节点值之和最大。
    public int maxGain(TreeNode node) {
        // 空结点最大贡献值等于0
        if (node == null) {
            return 0;
        }

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        // 计算以该结点为根且包含该结点的 最大路径和
        int priceNewpath = node.val + leftGain + rightGain;
        // 更新答案
        maxSum = Math.max(maxSum, priceNewpath);


        // 返回包含节点的最大贡献值
        return node.val + Math.max(leftGain, rightGain);
    }

}
