package com.Tree;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class visited {
    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) {
        visited a = new visited();
        TreeNode root = a.CreateTree(); // 创建子树

        a.postOrder(root);
        a.nonPostOrder(root);
    }

    // 递归创建二叉树
    Scanner input = new Scanner(System.in);

    public TreeNode CreateTree() {
        int data = input.nextInt();

        if (data == -1) { // 表示叶子结点
            return null;
        }

        // 否则创建该结点
        TreeNode node = new TreeNode();
        node.data = data;
        node.left = CreateTree();
        node.right = CreateTree();
        return node;

    }

    public void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + "  ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder(TreeNode root) {
        if (root != null) {
            preOrder(root.left);
            preOrder(root.right);
            System.out.print(root.data + "  ");
        }
    }

    public void nonPreOrder(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>(); // 创建一个队列

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                System.out.println(root.data);
                root = root.left;
            } else {
                root = stack.pop();

                root = root.right;
            }
        }
    }

    // 使用栈存储节点时，只需分清返回根节点的是从左子树返回的还是右子树返回的。所以需要辅助指针r，指向最近访问过的节点。
    public void nonPostOrder(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode r = null;

        while (root != null || !stack.isEmpty()) {

            if (root != null) { // 保证L走到最底下，
                stack.push(root);
                root = root.left;
            } else { // 准备检查R
                root = stack.element(); // 获得栈顶元素
                if (root.right != null && root.right != r) {
                    // 如果右子树存在，且没有被访问过，
                    root = root.right;
                } else {
                    // 访问结点
                    root = stack.pop();
                    System.out.println(root.data);

                    r = root; // 记录最近访问的节点
                    root = null; // 节点访问完，重置root指针

                }

            }
        }


    }


}
