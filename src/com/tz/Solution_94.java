package com.tz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_94 {

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


    public TreeNode createTree() {

        Scanner input = new Scanner(System.in);
        int data = input.nextInt(); //通过键盘输入数据
        if (data == -1) { // 对于输入，如果是-1 则表示该节点为null指针
            return null;
        }

        TreeNode tree = new TreeNode(data);
        tree.left = createTree();
        tree.right = createTree();
        return tree;

    }

    public static void main(String[] args) {
        Solution_94 a = new Solution_94();
        TreeNode tree = a.createTree();
        System.out.println(a.inorderTraversal(tree));

    }

    public List<Integer> inorderTraversal(TreeNode root) {

        // 模拟一个栈
        TreeNode[] stack = new TreeNode[100]; // 题目中说是最多100个结点
        int top = -1;

        List<Integer> ans = new ArrayList<>();


        while (top != -1 || root != null) { // 栈不为空 且 root 不为null
            while (root != null) {
                stack[++top] = root;
                root = root.left;
            }

            root = stack[top--]; // 出栈
            ans.add(root.val);


            root = root.right;
        }
        return ans;
    }


    // =========== 递归算法实现 ===============
    public List<Integer> inorderTraversal2(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        Traversal(root, ans);
        return ans;
    }


    public void Traversal(TreeNode root, List<Integer> ans) {
        if (root != null) {
            Traversal(root.left, ans);
            ans.add(root.val);
            Traversal(root.right, ans);
        }
    }


}
