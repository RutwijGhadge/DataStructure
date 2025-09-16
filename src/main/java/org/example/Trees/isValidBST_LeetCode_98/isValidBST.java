package org.example.Trees.isValidBST_LeetCode_98;

import org.example.Trees.Models.BuildTree;
import org.example.Trees.Models.TreeNode;

public class isValidBST {
    public static boolean checkValidBST(TreeNode root,int l,int r){
        if(root==null)
            return true;

        if(root.val>l && root.val<r){
            return (checkValidBST(root.left,l,root.val) && checkValidBST(root.right,root.val,r));
        }else {
            return false;
        }
    }
    public static void main(String[] args) {
        Integer[] input = {2, 1, 3};

        TreeNode root = BuildTree.buildTree(input);
       System.out.println(checkValidBST(root, Integer.MIN_VALUE,Integer.MAX_VALUE));
    }
}

/*
Important to Note : In the Leetcode DataTypes and the constraint
 */
