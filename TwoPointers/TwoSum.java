package DSA.TwoPointers;

import java.util.Arrays;

public class TwoSum {
    public static class Solution{
        public boolean twoSum(int[] arr, int target){
            // Sort the array
            Arrays.sort(arr);

            int left = 0, right = arr.length-1;

            while(left < right){
                int sum = arr[left] + arr[right];

                if(sum == target){
                    return true;
                } else if(sum < target){
                    left++;
                } else{
                    right--;
                }
            }
            return false;
        }
    }

    public static void main(String[] args){
        int[] arr = { 0, -1, 2, -3, 1 };
        int target = -2;

        Solution sol = new Solution();

        System.out.println(sol.twoSum(arr, target));
    }
}
