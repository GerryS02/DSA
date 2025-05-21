package BitManipulation;

public class SingleElement {
    public static class Solution{
        public int singleNumber(int[] nums){
            int ans = 0;

            for(int num : nums){
                // use XOr operator to every element in the array so that the duplicate numbers will cancel out
                ans ^= num; 
            }

            return ans;
        }
    }

    public static void main(String[] args){
        int nums[] = {4,1,2,1,2};

        Solution sol = new Solution();

        System.out.println("Output: "+ sol.singleNumber(nums));
    }

}
