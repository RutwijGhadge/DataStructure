package org.example.Sliding_window_Median_Leetocde_480;

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        //Running Median Application
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        double[] median = new double[nums.length - k + 1];
        int j = 0, i = 0;

        while (i < nums.length) {
            if (i < k) {
                maxheap.offer(nums[i]);
                if (maxheap.size() - minheap.size() > 1) {
                    minheap.offer(maxheap.poll());
                }
            } else {
                if (maxheap.size() - minheap.size() > 1) {
                    minheap.offer(maxheap.poll());
                }

                if (maxheap.size()<=minheap.size()) //even
                    median[j] = (double) (maxheap.peek() + minheap.peek()) / 2;
                else
                    median[j] = maxheap.peek();


                if (minheap.contains(nums[j]))
                    minheap.remove(nums[j]);
                else {
                    maxheap.remove(nums[j]);
                }
                maxheap.offer(nums[i]);
                j++;
            }
            i++;
        }
        return median;
    }
    public static void main(String[] args) {
        int[]nums={1,3,-1,-3,5,3,6,7};
        int k=3;
        double[]median=new double[nums.length-k+1];
        SlidingWindowMedian slidingWindowMedian=new SlidingWindowMedian();
        median=slidingWindowMedian.medianSlidingWindow(nums,k);
            for(int i=0;i<nums.length-k+1;i++){
                System.out.print(median[i] + "  " );
            }

    }
}
