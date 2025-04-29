package DSA.Array;

public class MaxChunksToMakeSorted {
    public static class Solution{
        public int MaxChunksToMakeSorted(int[] arr){
            int max = 0, chunks = 0;

            for(int i=0; i<arr.length; i++){
                max = Math.max(arr[i], max);

                if(max == i){
                    chunks++;
                }
            }
            return chunks;
        }
    }
}
