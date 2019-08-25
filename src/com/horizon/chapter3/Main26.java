package com.horizon.chapter3;

/**
 *  title : 树的子结构
 *  url : https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88?tpId=13&tqId=11170&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 */
public class Main26 {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean res = false;
        if (root1 != null && root2 != null) {
            // 根节点相同，比较整个树是否相同
            if (floatEqual(root1.val, root2.val)) {
                res = doesTree1HaveTree2(root1, root2);
            }
            // 如果已经存在则不用再递归了
            if (!res) {
                // 根节点不同，比较左节点
                res = HasSubtree(root1.left, root2);
            }
            if (!res) {
                // 根节点、左节点不同，比较右节点
                res = HasSubtree(root1.right, root2);
            }
        }
        return res;
    }

    private boolean floatEqual(int num1, int num2) {
        return (num1 - num2) > -10e-7 && (num1 - num2) < 10e-7;
    }

    private boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (!floatEqual(root1.val, root2.val)) {
            return false;
        }
        return doesTree1HaveTree2(root1.left, root2.left) && doesTree1HaveTree2(root1.right, root2.right);
    }

}
