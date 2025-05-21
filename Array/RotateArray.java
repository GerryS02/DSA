package Array;

import java.util.Arrays;

public class RotateArray {
    public static class Solution{
        public void rotate(int[] nums, int k){
            int n = nums.length;

            if(k > n){
                k = k % n;
            }

            reverse(nums, 0, n-1);
            reverse(nums, 0, k-1);
            reverse(nums, k, n-1);
        }

        public void reverse(int[] nums, int start, int end){

            while( start < end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;

                start++;
                end--;
            }
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();

        int[] nums = {1,2,3,4,5,6,7};

        solution.rotate(nums, 3);

        System.out.println("Rotated array: "+ Arrays.toString(nums));
    }
}
