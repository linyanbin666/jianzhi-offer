package com.horizon.chapter3;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  title : 二叉树的镜像
 *  url : https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011?tpId=13&tqId=11171&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Main27 {

    // 递归交换根节点的左右子节点
/*    public void Mirror(TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if (root.left != null) {
            Mirror(root.left);
        }
        if (root.right != null) {
            Mirror(root.right);
        }
    }*/

    // 循环
    public void Mirror(TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode qRoot = queue.poll();
            if (qRoot.left == null && qRoot.right == null)
                break;
            TreeNode tmp = qRoot.left;
            qRoot.left = qRoot.right;
            qRoot.right = tmp;
            if (qRoot.left != null) {
                queue.offer(qRoot.left);
            }
            if (qRoot.right != null) {
                queue.offer(qRoot.right);
            }
        }
    }

}
