package org.example.Trees.Inorder_Traversal;

import org.example.Trees.Models.BuildTree;
import org.example.Trees.Models.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class solution {
    public void iterative_InOrder(TreeNode root){
        Stack<TreeNode>st=new Stack<>();
        ArrayList<TreeNode>arr=new ArrayList<>();
        while(!st.isEmpty() || root!=null){
            if(root!=null){
                st.add(root);
                root=root.left;
            }else{
                root=st.pop();
                System.out.print(root.val + " ");
                root=root.right;
            }
        }
    }

    public void recursive_Inorder(TreeNode root){
        if(root==null){
            return;
        }
        recursive_Inorder(root.left);
        System.out.print(root.val +" ");
        recursive_Inorder(root.right);
    }

    public static void main(String[] args) {
        Integer[] input = {6, 1, 3, 2};

        TreeNode root = BuildTree.buildTree(input);
        solution sol=new solution();
        sol.iterative_InOrder(root);
        sol.recursive_Inorder(root);
    }
}
//Similarly we can print Preorder and Postorder Traversals