package org.example.MaximumProductSubArray;

import org.example.Models.TreeNode;
import org.example.Models.pair;

import java.util.*;

public class BuildTree {

    public static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();

            // Left child
            if (arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<pair>q=new LinkedList<>();
        List<List<Integer>>ans=new ArrayList<>();
        TreeNode curr=root;
        List<Integer>anss;
        int level=0;
        pair p;
        pair s;
        q.add(new pair(curr,0));
        Map<Integer,List<Integer>> hm=new TreeMap<>();
        int size=0;
        int levels=0;
        while(!q.isEmpty()){
            size=q.size();
            for(int i=0;i<size;i++){
                p=q.poll();
                levels=p.level;
                curr=p.node;
                if(!hm.containsKey(levels)){
                    anss=new ArrayList<>();
                }else{
                    anss=hm.get(levels);
                }
                anss.add(curr.val);
                hm.put(levels,anss);
                if(curr.left!=null){
                    q.add(new pair(curr.left,levels-1));
                }
                if(curr.right!=null){
                    q.add(new pair(curr.right,levels+1));
                }
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : hm.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }
    public static void main(String[] args) {
        Integer[] input = {1,2,3,4,6,5,7};

        TreeNode treeNode=BuildTree.buildTree(input);
        List<List<Integer>>ans=BuildTree.verticalTraversal(treeNode);
        for(int i=0;i<ans.size();i++){
            List<Integer>anss=new ArrayList<>();
            for(int j=0;j<ans.get(i).size();j++){
                anss=ans.get(i);
                System.out.println(anss.get(j));
            }
            System.out.println();
        }
    }
}
