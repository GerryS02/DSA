package DSA.Array;

public class numSubarrayBoundedMax {
    public static class Solution{
        public int numSubarrayBoundedMax(int[] nums, int left, int right){
            return countLessEquals(nums, right) - countLessEquals(nums, left-1);
        }
    
        public int countLessEquals(int[] nums, int bound){
            int count = 0, curr = 0;
            
            for(int num : nums){
                if(num <= bound){
                    curr++;
                } else{
                    curr = 0;
                }
    
                count += curr;
            }
            return count;
        }
    }

    public static void main(String[] args){
        int[] nums = {2,1,4,3};
        int left = 2;
        int right = 3;

        Solution solution = new Solution();
        
        int ans = solution.numSubarrayBoundedMax(nums, left, right);

        System.out.println("the number of subarrays are: "+ ans);

    }
}
