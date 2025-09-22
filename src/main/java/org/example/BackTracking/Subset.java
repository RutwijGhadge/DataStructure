package org.example.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    static List<List<Integer>>ans=new ArrayList<>();

    public static void subsets(int i,int[] sub, int size,List<Integer>temp){
        if(i==size){
            return;
        }

        temp.add(sub[i]);
        ans.add(new ArrayList<>(temp));
        subsets(i+1,sub,size,temp);
        temp.remove(temp.size()-1);
        subsets(i+1,sub,size,temp);
    }


    public static void main(String[] args) {
        int[]sub={1,2,3};
        int i=0;
        int size=sub.length;
        List<Integer>temp=new ArrayList<>();
        subsets(i,sub,size,temp);
        for (List<Integer> an : ans) {
            List<Integer> temps = new ArrayList<>(an);
            for (Integer integer : temps) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
//TC : O(2^n)
//SC : O(n)