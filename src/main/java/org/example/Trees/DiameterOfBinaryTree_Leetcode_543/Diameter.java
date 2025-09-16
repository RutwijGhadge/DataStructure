package org.example.Trees.DiameterOfBinaryTree_Leetcode_543;

import org.example.Trees.Models.BuildTree;
import org.example.Trees.Models.TreeNode;

public class Diameter {
    static int diameter=-1;
    public static int diameterTree(TreeNode A){
        heightTree(A);
        return diameter;
    }
    public static int heightTree(TreeNode A){
        if(A==null)
            return -1;
        int lh=heightTree(A.left)+1;
        int rh=heightTree(A.right)+1;

        diameter=Math.max(diameter,lh+rh);
        return Math.max(lh,rh);

    }

    public static void main(String[] args) {
        Integer[]ans={1,2,3,4,5,null,6,null,null,null,7};
        TreeNode treeNode= BuildTree.buildTree(ans);
        System.out.println(Diameter.diameterTree(treeNode));
    }
}
