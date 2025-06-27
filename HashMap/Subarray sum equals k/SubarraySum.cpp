class Solution{
    public:

    int subarraySum(vector<int>& arr, int k){
        int n = arr.size();
        int count = 0;
        vector<int> prefixSum(n, 0); //vector to store the prefix sum of elements of arr

        prefixSum[0] = arr[0];
        for(int i=1; i<n; i++){
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        unordered_map<int, int> m;
        for(int j=0; j<n; j++){
            //for subarray from 0 to j has sum = k
            if(prefixSum[j] == k) count++;

            // the prefix sum of subarray from i to j with sum = k
            int val = prefixSum[j] - k;

            //if val exist in the map, there is atleast one subarray from i to j with sum = k
            if(m.find(val) != m.end()){
                //add the frequency of the subarrays (ending with j) with sum = k to count
                count += m[val];
            }

            //if the map is empty, update with current prefix sum with frequency 0
            if(m.find(prefixSum[j]) == m.end()){
                m[prefixSum[j]] = 0;
            }
            //update the frequency of the current prefix sum
            m[prefixSum[j]]++;
        }
        return count;
    }
};