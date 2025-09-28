package org.example.MajorityFrequencyCharacters_LeetCode3692;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public String majorityFrequencyGroup(String s) {
    int[] count=new int[26];
    for(int i=0;i<s.length();i++){
        count[s.charAt(i)-'a']++;
    }//count frequency of all elements

    HashMap<Integer, List<Character>> hm=new HashMap<>();
    for(int i=0;i<26;i++){
        if(count[i]!=0) {
            if (!hm.containsKey(count[i])) {
                hm.put(count[i], new ArrayList());
            }
            List<Character> arr = hm.get(count[i]);
            arr.add((char) (i + 'a'));
            hm.put(count[i], arr);
        }
    }

    List<Map.Entry<Integer, List<Character>>> entries = new ArrayList<>(hm.entrySet());

    Collections.sort(entries, (e1, e2) -> {
        int cmp = Integer.compare(e2.getValue().size(), e1.getValue().size()); // by size desc
        if (cmp == 0) {
            return Integer.compare(e2.getKey(), e1.getKey()); // by key desc
        }
        return cmp;
    });

    return entries.get(0).getValue().stream().map(String::valueOf).collect(Collectors.joining());
}

    public static void main(String[] args) {
        String s="aaabbbccdddde";
        Solution st=new Solution();
        System.out.println(st.majorityFrequencyGroup(s));
    }
}
/*
You are given a string s consisting of lowercase English letters.

The frequency group for a value k is the set of characters that appear exactly k times in s.

The majority frequency group is the frequency group that contains the largest number of distinct characters.

Return a string containing all characters in the majority frequency group, in any order. If two or more frequency groups tie for that largest size, pick the group whose frequency k is larger.



Example 1:

Input: s = "aaabbbccdddde"

Output: "ab"
 */