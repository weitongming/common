package com.weitongming.algo.sword_of_offer;

/**
 * @author tim.wei
 * @description 查询树的深度
 * @date Created on 2019/3/19.
 */
public class DeptOfTree {


    public int TreeDepth(TreeNode pRoot)
    {
        if(pRoot == null){
            return 0;
        }
        int left = TreeDepth(pRoot.left);
        int right = TreeDepth(pRoot.right);
        return (left > right ? left : right) + 1;
    }


    private class TreeNode{
        int value ;
        TreeNode left ;
        TreeNode right ;
    }
}
