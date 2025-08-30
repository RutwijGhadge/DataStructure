package org.example.LowestCommonAncestor_LeetCode236;

import org.example.Models.BuildTree;
import org.example.Models.TreeNode;


public class FindLCA {
   //1st step to check whether both nodes are Present in Tree or Not
    public Boolean checkIfPresent(TreeNode root, int val){
        if(root==null){
            return false;
        }
        if(root.val==val){
            return true;
        }
        return (checkIfPresent(root.left,val) || checkIfPresent(root.right,val));
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(checkIfPresent(root,p.val) && checkIfPresent(root,q.val) ){
            //If both Nodes Present -> then Find LCA
            int B=p.val;
            int C=q.val;
            return LCA(root,B,C);
        }
    return null;
    }

    public TreeNode LCA(TreeNode root , int B,int C){
        if(root==null || root.val==B || root.val==C){//base Cases
            return root;
        }

        TreeNode left=LCA(root.left,B,C);
        TreeNode right=LCA(root.right,B,C);

        if(left!=null && right!=null) {
            return root;
        }

        if(left!=null){
            return left;
        }
        if(right!=null){
            return right;
        }

        return null;
    }

    public static void main(String[] args) {
        FindLCA findLCA =new FindLCA();
        Integer[] input = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode p=new TreeNode(5);
        TreeNode q=new TreeNode(1);
        TreeNode root= BuildTree.buildTree(input);
        if(findLCA.lowestCommonAncestor(root,p,q)!=null)
            System.out.println(findLCA.lowestCommonAncestor(root,p,q).val);
        else
            System.out.println("No LCA");
    }
}
