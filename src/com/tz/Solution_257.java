package com.tz;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;


public class Solution_257 {

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


    public List<String> binaryTreePaths(TreeNode root) {

        List<String> paths = new ArrayList<>();
        constructPaths(root, "", paths);
        return paths;
    }

    public void constructPaths(TreeNode node, String path, List<String> paths) {
        if (node != null) {
            // 重复语句，将其提取出来
            StringBuilder pathSB = new StringBuilder(path);
            pathSB.append(Integer.toString(node.val)); // 拼接叶子节点数据

            if (node.left == null && node.right == null) { // 叶子结点，把从根节点到该叶子结点的数据加入到paths中
                // 首先将该结点的数据加入到path后，由于java中String是final类型，因此考虑使用线程不安全的StringBuilder
//                StringBuilder pathSB = new StringBuilder(path);
//                pathSB.append(Integer.toString(node.val)); // 拼接叶子节点数据
                paths.add(pathSB.toString());

            } else {// 非叶子节点，将该结点数据加入到path中，并加上 -> ,然后递归调用左孩子和右孩子
//                StringBuilder pathSB = new StringBuilder(path);
//                pathSB.append(Integer.toString(node.val)); // 拼接叶子节点数据
                pathSB.append("->");

                constructPaths(node.left, pathSB.toString(), paths);
                constructPaths(node.right, pathSB.toString(), paths);
            }
        }


    }


}
