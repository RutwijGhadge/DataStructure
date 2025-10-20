package org.example.SlidingWindow.Sliding_window_LeetCode_424;

import java.util.Arrays;

public class SlidingWindow {
    public static void main(String[] args) {
        String s="AABABBA";
        int k=1;

        System.out.println(LongestRepeatingCharacterReplacement(s,k));
    }
    public static int LongestRepeatingCharacterReplacement(String s,int k){
        if(k==s.length())
            return s.length();

        int[]count=new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'A']++;
        }

        Arrays.sort(count);
        int sum=0;
        int start=0,end=count.length-1;

        while(start<end && sum<k){
            sum+=count[start];
            start++;
        }

        return (int)Math.min(k,sum)+count[count.length-1];
    }
}
/*
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
Return the length of the longest substring containing the same letter you can get after performing the above operations.
Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.


Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length
 */