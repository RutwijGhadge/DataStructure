package org.example.Trees.Sum_Binary_Tree_Or_Not;

import org.example.Trees.Models.BuildTree;
import org.example.Trees.Models.TreeNode;

public class SumBinaryTree {
   static boolean sum=true;
    public int solve(TreeNode root){
        if(root==null)
            return 0;

        int left_sum=solve(root.left);
        int right_sum=solve(root.right);

        if(left_sum==0 && right_sum==0){
            return root.val;
        }

        if(left_sum+right_sum!=root.val){
            sum=false;
        }
        return left_sum+right_sum+root.val;
    }


    public static void main(String[] args) {
        Integer[] input = {26,10,3,4,6,null,3};
        TreeNode root = BuildTree.buildTree(input);
        SumBinaryTree sumBinaryTree=new SumBinaryTree();
        sumBinaryTree.solve(root);
        System.out.println(sum);
    }
}
