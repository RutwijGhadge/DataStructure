package org.example.K_Closest_Elements_LeetCode658;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer>findClosestElements(int[]arr,int k, int x){
        List<Integer>ans=new ArrayList<>();
        int size=arr.length;
        int low=0;
        int high=size-k;
        int mid;
        while(low < high){
          mid=(low+high)/2;
          if(x - arr[mid] > arr[mid+k]-x){
              low=mid+1;
          }else{
              high=mid-1;
          }
        }
     return Arrays.stream(arr,low,low+k).boxed().toList();
        //Start Index-> Inclusive
        //Last Index -> Exclusive
    }
    public static void main(String[] args) {
        int []arr={1,2,3,4,5,6,7,8,9,12};
        int k=4;
        int x=3;
        Solution solution=new Solution();
        List<Integer>ans=solution.findClosestElements(arr,k, x);
        for (int i:ans)
            System.out.print(i+" ");
    }
}


/*
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array.
The result should also be sorted in ascending order.
An integer a is closer to x than an integer b if:
|a - x| < |b - x|, or
|a - x| == |b - x| and a < b

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
*/
