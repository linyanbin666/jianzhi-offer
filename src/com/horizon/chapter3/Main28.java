package com.horizon.chapter3;

/**
 *  title : 对称的二叉树
 *  url : https://www.nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb?tpId=13&tqId=11211&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class Main28 {

    boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot, pRoot);
    }

    // 根据二叉树的前序遍历序列和对称前序遍历序列来判断二叉树是否是对称的
    private boolean isSymmetrical(TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot1 == null && pRoot2 == null)
            return true;
        if (pRoot1 == null || pRoot2 == null)
            return false;
        if (pRoot1.val != pRoot2.val)
            return false;
        return isSymmetrical(pRoot1.left, pRoot2.right) && isSymmetrical(pRoot1.right, pRoot2.left);
    }

}
