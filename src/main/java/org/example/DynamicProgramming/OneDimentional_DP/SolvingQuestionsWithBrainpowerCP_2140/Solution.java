package org.example.DynamicProgramming.OneDimentional_DP.SolvingQuestionsWithBrainpowerCP_2140;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
You are given a 0-indexed 2D integer array questions where questions[i] = [pointsi, brainpoweri].

The array describes the questions of an exam, where you have to process the questions in order (i.e., starting from question 0) and make a decision whether to solve or skip each question. Solving question i will earn you pointsi points but you will be unable to solve each of the next brainpoweri questions. If you skip question i, you get to make the decision on the next question.

For example, given questions = [[3, 2], [4, 3], [4, 4], [2, 5]]:
If question 0 is solved, you will earn 3 points but you will be unable to solve questions 1 and 2.
If instead, question 0 is skipped and question 1 is solved, you will earn 4 points but you will be unable to solve questions 2 and 3.
Return the maximum points you can earn for the exam.
 */
public class Solution {
    public static long maxPower(long[]dp,int[][] questions,int i,int n){
        //2 choices : either to attempt the question or to skip it

        if(i>=n){
            return 0;
        }
        if(dp[i]!=-1)
            return dp[i];

        long attempt=questions[i][0] + maxPower(dp,questions,i+questions[i][1]+ 1,n);//i+questions[i][1]+ 1 : Next valid index possible for attempting
        long skip=maxPower(dp,questions,i+1,n);

        return dp[i]=Math.max(attempt,skip);
    }
    public static void main(String[] args) {
        int[][] questions = {
                {3, 2},
                {4, 3},
                {4, 4},
                {2, 5}
        };
        long[] dp=new long[questions.length];
        Arrays.fill(dp,-1);
        int n=dp.length;
        System.out.println(maxPower(dp,questions,0,n));
    }

}
