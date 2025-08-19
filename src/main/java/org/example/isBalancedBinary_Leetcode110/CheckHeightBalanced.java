package org.example.isBalancedBinary_Leetcode110;

import org.example.Models.BuildTree;
import org.example.Models.TreeNode;

public class CheckHeightBalanced {
    static boolean isBalance=true;
    public static boolean isBalanced(TreeNode root){
        checkIsBalance(root);
        return isBalance;
    }

    public static int checkIsBalance(TreeNode treeNode){
        if(treeNode==null)
            return -1;

        int lh=checkIsBalance(treeNode.left);
        int rh=checkIsBalance(treeNode.right);

        if(Math.abs(lh-rh)>1){
            isBalance=false;
            return -1;
        }
        return Math.max(lh,rh)+1;
    }

    public static void main(String[] args) {
      // Integer[]arr={3,9,20,null,null,15,7};
       Integer[]arr={1,2,2,3,3,null,null,4,4};

        TreeNode root = BuildTree.buildTree(arr);
        System.out.println(isBalanced(root));
    }
}
/*
             3
          9     20
       n    n  15     7

 */