import java.util.HashMap;

class Solution{
    public int subarraySum(int[] arr, int k){
        int n = arr.length;
        int count = 0;
        int[] prefixSum = new int[n];

        prefixSum[0] = arr[0];
        for(int i=1; i<n; i++){
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        HashMap<Integer, Integer> m = new HashMap<>();
        
        for(int j=0; j<n; j++){
            if(prefixSum[j] == k) count++;

            int val = prefixSum[j] - k;

            if(m.containsKey(val)){
                count += m.get(val);
            }

            if(m.containsKey(prefixSum[j])){
                m.put(prefixSum[j], m.get(prefixSum[j])+1);
            } else{
                m.put(prefixSum[j], 1);
            }
        }
        return count;
    }
}