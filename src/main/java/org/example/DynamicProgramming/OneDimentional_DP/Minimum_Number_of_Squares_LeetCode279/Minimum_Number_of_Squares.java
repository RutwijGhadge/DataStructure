package org.example.DynamicProgramming.OneDimentional_DP.Minimum_Number_of_Squares_LeetCode279;

import java.util.Arrays;

public class Minimum_Number_of_Squares {
    int ans=Integer.MAX_VALUE;
    static int cnt=0;
    public int solution(int n,int[]dp){
        if(n==0)
            return 0;
        if(dp[n]!=-1)
            return dp[n];

        int min_squares=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            int nxt_square=solution(n-i*i,dp);
            min_squares=Math.min(min_squares,nxt_square+1);
        }
        return dp[n]=min_squares;
    }

    public static void main(String[] args) {
        int n=12;
        int[]dp=new int[n+1];
        Arrays.fill(dp,-1);
        Minimum_Number_of_Squares minimumNumberOfSquares=new Minimum_Number_of_Squares();
        System.out.println(minimumNumberOfSquares.solution(n,dp));
    }
}

//Optimal Substructure + Repetition of SubProblems