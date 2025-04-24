package DSA.Array;
import java.util.Arrays;

public class SquareOfSortedArray {
    public static class Solution{
        public int[] sortedSquares(int[] nums){
            int n = nums.length;
            int[] ans = new int[n];

            int first = 0, last = n-1;
            int pos = n-1;

            while(first <= last){
                int leftSqr = nums[first]* nums[first];
                int rightSqr = nums[last]* nums[last];

                if(leftSqr > rightSqr){
                    ans[pos--] = leftSqr;
                    first++;
                } else{
                    ans[pos--] = rightSqr;
                    last--;
                }
            }
            return ans;
        }

        public static void main(String[] args){
            Solution solution = new Solution();

            int[] nums = {-4,-1,0,3,10};
            int[] result = solution.sortedSquares(nums);

            System.out.println("Squared Array: "+ Arrays.toString(result));
        }
    }
}
