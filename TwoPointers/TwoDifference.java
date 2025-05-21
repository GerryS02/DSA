package TwoPointers;

import java.util.Arrays;

public class TwoDifference {
    public static class Solution{
        public boolean findPair(int[] arr, int x){
            int n = arr.length;

            Arrays.sort(arr);

            int j = 1;

            for(int i=0; i<n; i++){
                while(j < n && arr[j] - arr[i] < x){
                    j++;
                }

                while(j<n && i != j && arr[j] - arr[i] == x){
                    return true;
                }
            }
            return false;
        }

        public static void main(String[] args){
            int[] arr = {5, 20, 3, 2, 50, 80};
            int x = 78;

            Solution sol = new Solution();

            System.out.println(sol.findPair(arr, x));
        }
    }
}
