package org.example.Strings;

public class PalindromeSubstringLeetCode_5 {
    public static String findLongestPalindrome(String s){
        String subsequence="";

        for(int i=0;i<s.length();i++){
            String palindrome="";
            palindrome=checkPalindrome(s,i,i); //if we want to consider Odd Length Palindrome
            if(subsequence.length()<palindrome.length()){//preference should be given to Substring which occurs first ( with the least starting index)
                subsequence=palindrome;
            }

            palindrome=checkPalindrome(s,i,i+1);//if we want to consider Even Length Palindrome
            if(subsequence.length()<palindrome.length()){
                subsequence=palindrome;
            }
        }

        return subsequence;
    }

    public static String checkPalindrome(String s, int i, int j){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }

        return s.substring(i+1,j);
        //j exclusive & i inclusive
    }

    public static void main(String[] args) {
        String s="ababd";
        System.out.println(findLongestPalindrome(s));
    }
}

/*
Given a string A of size N, find and return the longest palindromic substring in A.

Substring of string A is A[i...j] where 0 <= i <= j < len(A)

Palindrome string:
A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.

Incase of conflict, return the substring which occurs first ( with the least starting index).
 */