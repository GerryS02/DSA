package Array;

import java.util.Arrays;

public class RangeAddition {
    public static class Solution{
        public int[] getModifiedArray(int n, int[][] updates){
            int[] ans = new int[n];

            for(int i=0; i<updates.length; i++){
                int start = updates[i][0];
                int end = updates[i][1];
                int inc = updates[i][2];

                ans[start] += inc;

                if(end+1 < n){
                    ans[end+1] -= inc;
                }
            }

            for(int i=1; i<n; i++){
                ans[i] = ans[i] + ans[i-1];
            }
            return ans;
        }
    }

    public static void main(String[] args){
        int updates[][] = {
            {1,3,2},
            {2,4,3},
            {0,2,-2}
        };

        Solution sol = new Solution();

        int[] result = sol.getModifiedArray(5, updates);

        System.out.println(Arrays.toString(result));
    }
}
