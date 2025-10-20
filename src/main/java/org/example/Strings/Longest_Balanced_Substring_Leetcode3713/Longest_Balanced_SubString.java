package org.example.Strings.Longest_Balanced_Substring_Leetcode3713;

public class Longest_Balanced_SubString {
    public static int findLongestBalancedSubstring(String s){
        int n=s.length(),ans=0;
        for(int i=0;i<n;i++){
            if(ans>=n-i) //not possible to retrieve the maximum ans
                break;
            int[]freq = new int[26];
            for(int j=i;j<n;j++) {
                int first=-1;
                freq[s.charAt(j)-'a']++;
                boolean valid=true;
                freq[s.charAt(j) - 'a']++; //count the occurrence
                for (int c : freq) {
                    if (c == 0)
                        continue;
                    if (first == -1) {
                        first = c;
                    } else if (c != first) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
    return ans;
    }

    public static void main(String[] args) {
        String s="abba";
        System.out.println(findLongestBalancedSubstring(s));
    }
}

/*
You are given a string s consisting of lowercase English letters.
A substring of s is called balanced if all distinct characters in the substring appear the same number of times.
Return the length of the longest balanced substring of s.

Example 1:
Input: s = "abbac"
Output: 4
Explanation:
The longest balanced substring is "abba" because both distinct characters 'a' and 'b' each appear exactly 2 times.

Example 2:
Input: s = "zzabccy"
Output: 4
Explanation:
The longest balanced substring is "zabc" because the distinct characters 'z', 'a', 'b', and 'c' each appear exactly 1 time.​​​​​​​

Example 3:
Input: s = "aba"
Output: 2
Explanation:
One of the longest balanced substrings is "ab" because both distinct characters 'a' and 'b' each appear exactly 1 time. Another longest balanced substring is "ba".

Constraints:
1 <= s.length <= 1000
s consists of lowercase English letters.
*/