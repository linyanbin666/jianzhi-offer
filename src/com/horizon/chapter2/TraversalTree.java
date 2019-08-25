package com.horizon.chapter2;

import org.junit.jupiter.api.Test;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 二叉树前序遍历实现
 */
public class TraversalTree {

    // 前序遍历
    public static List<Integer> preOrder(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        preOrderCoreLoop(root, res);
        return res.stream().map(node -> node.val).collect(Collectors.toList());
    }

    // 前序遍历递归实现
    private static void preOrderRecursion(TreeNode root, List<TreeNode> res) {
        if (root == null)
            return;
        res.add(root);
        preOrderRecursion(root.left, res);
        preOrderRecursion(root.right, res);
    }

    // 前序遍历循环实现
    private static void preOrderCoreLoop(TreeNode root, List<TreeNode> res) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                res.add(p);
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                // 弹出
                p = stack.pop();
                // 访问右子树
                p = p.right;
            }
        }
    }

    // 中序遍历
    public static List<Integer> inOrder(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        inOrderLoop(root, res);
        return res.stream().map(node -> node.val).collect(Collectors.toList());
    }

    // 中序遍历递归实现
    private static void inOrderRecursion(TreeNode root, List<TreeNode> res) {
        if (root == null) {
            return;
        }
        inOrderRecursion(root.left, res);
        res.add(root);
        inOrderRecursion(root.right, res);
    }

    // 中序遍历循环实现
    private static void inOrderLoop(TreeNode root, List<TreeNode> res) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                res.add(p);
                p = p.right;
            }
        }
    }

    // 后序遍历
    public static List<Integer> postOrder(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        postOrderLoop(root, res);
        return res.stream().map(node -> node.val).collect(Collectors.toList());
    }

    // 后序遍历递归实现
    private static void postOrderRecursion(TreeNode root, List<TreeNode> res) {
        if (root == null)
            return;
        postOrderRecursion(root.left, res);
        postOrderRecursion(root.right, res);
        res.add(root);
    }

    // 后序遍历循环实现
    private static void postOrderLoop(TreeNode root, List<TreeNode> res) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root, preNode = null;
        // 找到左下角节点
        while (curNode != null) {
            stack.push(curNode);
            curNode = curNode.left;
        }

        while (!stack.isEmpty()) {
            curNode = stack.pop();
            // 判断是否可以当根访问
            if (curNode.right == null || curNode.right == preNode) {
                res.add(curNode);
                preNode = curNode;
            } else {
                // 遍历右子树
                stack.push(curNode);
                curNode = curNode.right;
                while (curNode != null) {
                    stack.push(curNode);
                    curNode = curNode.left;
                }
            }
        }
    }
}
