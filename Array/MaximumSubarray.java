package Array;

// find the maximum sum of a subarray using Kadane's algorithm


public class MaximumSubarray {
    public static class Solution {
        public int maxSubArray(int[] nums) {
            int n = nums.length;

            // initializs the current and max sum till now with the first element
            int curr = nums[0] , maxTillNow = nums[0];
            
            // start from the second element
            for(int i=1; i<n; i++){

                // Calculate the new current sum by either taking the current element alone
                // or extending the previous subarray sum by adding the current element
                curr = Math.max(nums[i], curr + nums[i]);

                //update the max sum
                maxTillNow = Math.max(maxTillNow, curr);
    
                // if the current sum becomes negative, set it to 0
                if(curr<0){
                    curr = 0;
                }
            }
            return maxTillNow; 
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = solution.maxSubArray(nums);

        System.out.println("Maximum subarray sum is: " + result);
    }
}
