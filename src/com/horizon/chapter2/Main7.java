package com.horizon.chapter2;

import org.junit.jupiter.api.Test;

/**
 *  title : 重建二叉树
 *  url : https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=13&tqId=11157&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Main7 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || in == null ||
                pre.length == 0 || in.length == 0 ||
                pre.length != in.length) {
            return null;
        }
        return reConstructBinaryTreeCore(pre, 0, in, 0, in.length - 1);
    }

    private TreeNode reConstructBinaryTreeCore(int[] pre, int index, int[] in,
                                               int start, int end) {
        if (index >= pre.length)
            return null;
        if (start > end)
            return null;
        TreeNode root = new TreeNode(pre[index]);
        int searchIndex = -1;
        for (int i = start; i <= end; i++) {
            if (pre[index] == in[i]) {
                searchIndex = i;
                break;
            }
        }
        if (searchIndex != -1) {
            root.left = reConstructBinaryTreeCore(pre, index + 1, in, start, searchIndex - 1);
            root.right = reConstructBinaryTreeCore(pre, index + searchIndex - start + 1, in,searchIndex + 1, end);
        }

        return root;
    }

    @Test
    public void test() {
        int[] pre = {1,2,4,7,3,5,6,8}, in = {4,7,2,1,5,3,8,6};
        TraversalTree.preOrder(reConstructBinaryTree(pre, in)).forEach(i -> System.out.print(i + " "));
        System.out.println();
        TraversalTree.inOrder(reConstructBinaryTree(pre, in)).forEach(i -> System.out.print(i + " "));
        System.out.println();
        TraversalTree.postOrder(reConstructBinaryTree(pre, in)).forEach(i -> System.out.print(i + " "));
    }

}


