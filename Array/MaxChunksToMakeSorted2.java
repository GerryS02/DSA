package Array;

public class MaxChunksToMakeSorted2 {
    public static class Solution{
        public int maxChunksToMakeSorted(int[] arr){
            int n = arr.length;
            int[] left = new int[n];
            int[] right = new int[n+1];

            left[0] = arr[0];
            for(int i=1; i<n; i++){
                left[i] = Math.max(left[i-1], arr[i]);
            }

            right[n] = Integer.MAX_VALUE;
            for(int i=n-1; i>=0; i++){
                right[i] = Math.min(right[i+1], arr[i]);
            }

            int chunks = 0;
            for(int i=0; i<n; i++){
                if(left[i] <= right[i+1]){
                    chunks++;
                }
            }
            return chunks;
        }
    }
}
