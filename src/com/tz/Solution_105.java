package com.tz;

import java.util.HashMap;
import java.util.Map;

public class Solution_105 {

    // 定义二叉树节点的数据结构
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

    // 回到问题，知道
    // 先序遍历  根  [..左..]  [..右..]
    // 后序遍历  [..左..]  根  [..右..]

    // 那么很容易想到递归的思想，对于先序遍历 ，确定 根节点后，需要从后序遍历中找到 左子树的和右子树的节点数目。然后返回到后序遍历中，通过递归调用左右子树。。
    // 还有一个细节问题，就是说在划分 完 左右子树后，其左子树（右子树） 的先序遍历与中序遍历长度是一致的，但是其下标却未必有关系，所以在递归的时候需要把划分完后的
    // 先序遍历与中序遍历区间得传入函数中，即 先序区间[pre_start,pre_end] ， 中序区间 [in_start,in_end]

    // 那么问题在于，如何查找左右子树的数目呢。。 一般是通过直接扫描的方式，不过这种方式时间复杂度比较高，所以进行优化
    // 使用hashmap，对于哈希映射中的每个键值对，键表示一个元素（节点的值），值表示其在中序遍历中的出现位置。

    public Map<Integer, Integer> indexMap = null;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return recursion(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

    }

    // recursion 递归
    public TreeNode recursion(int[] preorder, int pre_start, int pre_end, int[] inorder, int in_start, int in_end) {
        // 表示空结点，所以返回null
        if (pre_start > pre_end || in_start > in_end) {
            return null;
        }

        // 创建根节点，
        int root_val = preorder[pre_start]; // 先序遍历第一个为根节点
        TreeNode root = new TreeNode(root_val);

        // 划分左右子树，从中序遍历中找到root节点的位置
        int in_root_index = indexMap.get(root_val);
//        int in_root_index = 0;
//        for (int i = in_start; i <= in_end; i++) {
//            if (inorder[i] == root_val) {
//                in_root_index = i;
//                break; // 找到了就结束
//            }
//        }


        // 回到先序遍历中，左子树的个数可以通过中序遍历中下标求得
        int left_node_number = in_root_index - in_start;

        //            pre_start                                 pre_end
        //               |                                       |
        // 先序遍历: [    根           [ ..左.. ]           [ ..右.. ]   ]
        //
        // 后序遍历: [    [ ..左.. ]         根             [ ..右.. ]  ]
        //               |                                       |
        //           in_start                                  in_end

        // 那么递归的实现左子树
        root.left = recursion(preorder, pre_start + 1, pre_start + left_node_number
                , inorder, in_start, in_root_index - 1);

        // 递归右子树
        root.right = recursion(preorder, pre_start + left_node_number + 1, pre_end
                , inorder, in_root_index + 1, in_end);

        return root;
    }


}
