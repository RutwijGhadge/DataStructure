package org.example.TwoLetterCardGame_Leetcode3664;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int score(String[] cards, char x) {
    List<String> str=new ArrayList<>();
        for(String s:cards){
        if(s.indexOf(x)!= -1) {
                str.add(s);
        }
    }
    //adding string that contains x

    HashMap<Character,Integer>hm0=new HashMap<>();
    HashMap<Character,Integer>hm1=new HashMap<>();
    HashMap<Character,Integer> hm2=new HashMap<>();

        for(String s:str){
        if(s.charAt(0)==x && s.charAt(1)!=x && !hm0.containsKey(s.charAt(1))){
            hm0.put(s.charAt(1),hm0.getOrDefault(s.charAt(1),0)+1);
        }else if(s.charAt(1)==x && s.charAt(0)!=x && !hm1.containsKey(s.charAt(0))){
            hm1.put(s.charAt(0),hm1.getOrDefault(s.charAt(0),0)+1);
        }else if(s.charAt(0)==x && s.charAt(1)==x){
            hm2.put(s.charAt(0),hm2.getOrDefault(x,0)+1);
        }
    }
    int point=0;
    int[]ans=new int[3];
    int result=0;
    int j=0;
        for(Map<Character,Integer> map:List.of(hm0,hm1,hm2)){
        for(Map.Entry<Character,Integer>hm:map.entrySet()){
            result+=hm.getValue();
        }
        ans[j++]=result;
        result=0;
    }
    //1 1 0
        for(int i=0;i<2;i++){
        point+=ans[i]/2;
        ans[i]=ans[i]%2;
    }

        if(ans[0]==1 && ans[2]>0 ){
        point+=1;
        ans[2]--;
    }
        if(ans[1]==1 && ans[2]>0){
        point+=1;
        ans[2]--;
    }
        return point;
}
    public static void main(String[] args) {
        String[]cards={"aa","ab","aa","ba"}; //"aa","ab","ba","ac"
        char x='a';
        Solution s=new Solution();
        System.out.println(s.score(cards,x));
    }
}
