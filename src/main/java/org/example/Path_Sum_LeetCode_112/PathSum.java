package org.example.Path_Sum_LeetCode_112;

import org.example.Models.BuildTree;
import org.example.Models.TreeNode;

public class PathSum {
    public int hasPathSum(TreeNode root,int TargetSum,int CurrentSum){
        if(root==null)
            return 0;

        CurrentSum+=root.val;
        if(root.left==null && root.right==null && TargetSum==CurrentSum){
            return 1;
        }else if(hasPathSum(root.left,TargetSum,CurrentSum)==1 || hasPathSum(root.right,TargetSum,CurrentSum)==1){
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Integer[] input = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        int TargetSum =22;
        int CurrentSum=0;
        TreeNode root = BuildTree.buildTree(input);
        PathSum pathSum=new PathSum();
        System.out.println(pathSum.hasPathSum(root,TargetSum,CurrentSum));
    }
}