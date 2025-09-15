package org.example.Comparators;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sorting {
     static class pair{
        int time;
        int profit;

         public pair(int time, int profit) {
             this.time = time;
             this.profit = profit;
         }
     }
     static class student{
         String name;
         int marks;
         int id;

         public student(String name, int marks, int id) {
             this.name = name;
             this.marks = marks;
             this.id = id;
         }
     }

    public static void main(String[] args) {
        int[]time={1,3,2,3,3};
        int[]profit={5,6,1,3,9};
        String[]name={"john","alice","alice","alex","anthony"};
        int[]marks={88,92,92,70,91};
        int[]id={3,1,2,5,4};
        List<pair>pairList=new ArrayList<>();
        List<student>studentList=new ArrayList<>();

        for(int i=0;i<time.length;i++){
            pairList.add(new pair(time[i],profit[i]));
            studentList.add(new student(name[i],marks[i],id[i]));
        }

        pairList.sort(Comparator.comparing(s -> s.time));
        for(int i=0;i<pairList.size();i++){
            System.out.print( pairList.get(i).time + " -> "+ pairList.get(i).profit);
            System.out.println();
        }

    }
}
