package org.example.DynamicProgramming.Minimum_Number_of_Squares_LeetCode279;

import java.util.Arrays;

public class Minimum_Number_of_Squares {
    int ans=Integer.MAX_VALUE;
    static int cnt=0;
    public int solution(int n,int[]dp){

        if(dp[n]!=-1)
            return dp[n];

        for(int i=1;i*i<=n;i++){
            cnt++;
            ans=Math.min(ans,solution(n-i*i,dp));
        }
    
        dp[n]=ans+1;
        System.out.print(dp[n]+ " ");
        return dp[n];
    }

    public static void main(String[] args) {
        int n=12;
        int[]dp=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        Minimum_Number_of_Squares minimumNumberOfSquares=new Minimum_Number_of_Squares();
        System.out.println(minimumNumberOfSquares.solution(n,dp));
        System.out.println("Total Number of Calls : "+cnt);
    }
}

//Optimal Substructure + Repetition of SubProblems