package DSA.Array;

// Longest Continuous Incresting Subarray


public class LCIS {

    public static class Solution{
        public int findLengthOfLCIS(int[] nums){

            if(nums.length == 0){
                return 0;
            }

            int currLen = 1;
            int maxLen = 1;

            for(int i=1; i<nums.length; i++){
                // if the current element is greater than the previous element
                if(nums[i] > nums[i-1]){
                    // increment the current length
                    currLen++;
                    // modify the max length as the current sequence is longest
                    maxLen = Math.max(currLen, maxLen);
                } else{
                    currLen = 1;
                }
            }
            return maxLen;
        } 
    }
    public static void main(String[] args){
        Solution solution = new Solution();

        int[] nums = {1, 3, 5, 4, 7};
        int result = solution.findLengthOfLCIS(nums);

        System.out.println("Length of longest continuous increasing subsequence is: " + result);
    }
}
