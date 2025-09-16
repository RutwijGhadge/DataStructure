package org.example.Trees.SymmetricBinaryTree_LeetCode_101;

import org.example.Trees.Models.BuildTree;
import org.example.Trees.Models.TreeNode;

public class Symmetric {
    public String isSymmetric(TreeNode root){
        if(isSymmetricCheck(root.left,root.right))
            return "Symmetric";
        return "Not Symmetric";
    }

    public Boolean isSymmetricCheck(TreeNode A, TreeNode B){
        if(A==null && B==null)
            return true;

        if(A!=null && B!=null && A.val==B.val){
            return isSymmetricCheck(A.left,B.right) && isSymmetricCheck(A.right,B.left);
        }

        return false;
    }
    public static void main(String[] args) {
        Integer[] input = {1,2,2,3,4,4,3};
        TreeNode root = BuildTree.buildTree(input);
        Symmetric symmetric=new Symmetric();
        assert root != null;
        System.out.println(symmetric.isSymmetric(root));
    }
}

/*
Note : If we want to compare the Nodes from the right and the Left tree at the Same Time as we did in this Question
       you should pass left and right subtree to the recursive function and trat them as a separate tree.

 */