package com.weitongming.algo;


/**
 * @author tim.wei
 * @description
 * @date Created on 2019/3/19.
 */
public class IsTreeBalance {

    //平衡二叉树的定义是空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树
    //核心思想是递归，从根节点开始。
    public boolean IsBalanced_Solution(TreeNode root) {
        //判断当前树是不是空 ，空树是二叉树
        if(root == null){
            return true;
        }
        //取左树深度
        int leftDept = treeDept(root.left);
        //取右树深度
        int rightDept = treeDept(root.right);
        //深度小于1为真
        if ( -1 <= (leftDept - rightDept) &&  (leftDept - rightDept) <= 1){
            //接着递归
            return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
        }
        else{
            //return false ;
            return false;
        }
    }

    //get  dept of the tree
    public int treeDept(TreeNode root){
        if(root == null){
            return 0 ;
        }
        int left = treeDept(root.left);
        int right = treeDept(root.right);
        return (left > right ? left : right) + 1;
    }


    private class TreeNode{
        int value ;
        TreeNode left ;
        TreeNode right ;
    }
}