package DSA.Array;

import java.util.Arrays;

public class MinimumNumberOfPlatforms {
    public static class Solution{
        public int minPlatforms(int[] arr, int[] dep){
            Arrays.sort(arr);
            Arrays.sort(dep);

            int i = 0, j = 0;
            int count = 0;
            int maxCount = 0;

            while(i < arr.length){
                if(arr[i] <= dep[j]){
                    count++;
                    i++;
                } else{
                    count--;
                    j++;
                }

                maxCount = Math.max(count, maxCount);
            }

            return maxCount;
        }
    }

    public static void main(String[] args){
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};

        Solution solution = new Solution();

        int minPlatforms = solution.minPlatforms(arr, dep);

        System.out.println("Minimum platforms required: " + minPlatforms);
    }
}
