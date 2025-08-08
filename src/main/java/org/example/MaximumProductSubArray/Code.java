package org.example.MaximumProductSubArray;

public class Code {
    /*
   Given an integer array nums, find a subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.


Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.


Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any subarray of nums is guaranteed to fit in a 32-bit integer.
     */
    public static void main(String[] args) {
        //keeping curr_product, previous_max,previous_min values
        int[]nums= new int[5];
        //[2,-5,-2,-4,3]
        nums[0]=2;
        nums[1]=-5;
        nums[2]=-2;
        nums[3]=-4;
        nums[4]=3;
        int previous_max=nums[0];
        int previous_min=nums[0];
        int overall_max=nums[0];
        for(int i=1;i<nums.length;i++){
            //1st calculate min,then max and last overall_max
            int max=Math.max(nums[i]*previous_min,Math.max(nums[i]*previous_max,nums[i]));
            previous_min=Math.min(nums[i]*previous_min,Math.min(nums[i]*previous_max,nums[i]));
            previous_max=max;
            overall_max=Math.max(overall_max,previous_max);
        }
        System.out.println(overall_max);
    }
}
