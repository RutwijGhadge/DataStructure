package org.example.BackTracking.Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Permutations {
    ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer>nums){
        HashSet<Integer>hs=new HashSet<>();
        int n=nums.size();
        generatePermutations(nums,n,hs,new ArrayList<>());
        return ans;
    }

    public void generatePermutations(List<Integer>nums,int n,HashSet<Integer>hs,ArrayList<Integer>list){
        if(list.size()==n){  //base condition
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=0;i<nums.size();i++){
            if(!hs.contains(nums.get(i))){ //Keeping check on Duplicates
                hs.add(nums.get(i));
                list.add(nums.get(i)); //do step

                generatePermutations(nums,n,hs,list);

                hs.remove(nums.get(i));
                list.remove(list.size()-1);//undo step
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> nums =new ArrayList<>(Arrays.asList(1,2,3));
        Permutations permutations=new Permutations();
        ArrayList<ArrayList<Integer>>ans=permutations.permute(nums);
        for (List<Integer> an : ans) {
            List<Integer> temps = new ArrayList<>(an);
            for (Integer integer : temps) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}

//Problem Description
//
//Given an integer array A of size N denoting collection of numbers , return all possible permutations.
//
// NOTE:
//
//No two entries in the permutation sequence should be the same.
//For the purpose of this problem, assume that all the numbers in the collection are unique.
//Return the answer in any order