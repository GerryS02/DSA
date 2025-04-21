package DSA.Array;

public class MaximumSubarray {
    class Solution {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            int curr = nums[0] , maxTillNow = nums[0];
    
            for(int i=1; i<n; i++){
                curr = Math.max(nums[i], curr + nums[i]);
                maxTillNow = Math.max(maxTillNow, curr);
    
                if(curr<0){
                    curr = 0;
                }
            }
            return maxTillNow; 
        }
    }

    public static void main(String[] args) {
        MaximumSubarray outer = new MaximumSubarray();
        Solution solution = outer.new Solution();

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = solution.maxSubArray(nums);

        System.out.println("Maximum subarray sum is: " + result);
    }
}
