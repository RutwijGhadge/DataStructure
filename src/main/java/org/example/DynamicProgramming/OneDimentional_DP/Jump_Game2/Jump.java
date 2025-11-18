package org.example.DynamicProgramming.OneDimentional_DP.Jump_Game2;

import java.util.Arrays;

public class Jump {
    public int jump(int[]nums){
        int[]dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return jump_game(nums,dp,0);
    }
    public int jump_game(int[]nums,int[]dp,int index){
        if(index==nums.length-1)
            return 0;

        if(dp[index]!=-1)
            return dp[index];

        int min_jumps=Integer.MAX_VALUE;
        for(int jump=1;jump<=nums[index] && jump+index<nums.length ;jump++){
            int next_jump=jump_game(nums,dp,index+jump);

            if(next_jump!=Integer.MAX_VALUE)
                min_jumps=Math.min(min_jumps,next_jump+1);
        }
        return dp[index]=min_jumps;
    }
    
    public static void main(String[] args) {
        int[]nums={2,3,1,1,4};
        Jump jump=new Jump();
        System.out.println(jump.jump(nums));
    }
}
/*
You are given a 0-indexed array of integers nums of length n. You are initially positioned at index 0.

Each element nums[i] represents the maximum length of a forward jump from index i. In other words,
if you are at index i, you can jump to any index (i + j) where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach index n - 1. The test cases are generated such that you can reach index n - 1.
 */