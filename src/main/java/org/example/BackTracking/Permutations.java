package org.example.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> permute(List<Integer> nums) {
        ArrayList<Integer> curr = new ArrayList<>();
        Collections.sort(nums); // sort first to handle duplicates
        boolean[] used = new boolean[nums.size()];
        backtrack(nums, curr, used);
        return ans;
    }

    private void backtrack(List<Integer> nums, List<Integer> curr, boolean[] used) {
        if (curr.size() == nums.size()) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            // skip if already used
            if (used[i]) continue;

            // skip duplicates (only if previous identical number wasn't used in this branch)
            if (i > 0 && nums.get(i) == nums.get(i - 1) && !used[i - 1])
                continue;

            // choose
            used[i] = true;
            curr.add(nums.get(i));

            // recurse
            backtrack(nums, curr, used);

            // unchoose
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        List<Integer>nums=new ArrayList<>(Arrays.asList(1,1,2));
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
/*
Given an array A of size N denoting collection of numbers that might contain duplicates, return all possible unique permutations.
NOTE: No 2 entries in the permutation sequence should be the same.
 */