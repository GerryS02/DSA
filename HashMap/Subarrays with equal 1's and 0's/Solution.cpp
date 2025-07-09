class Solution{
public:

    long long int countSubarrWithEqualZeroAndOne(int arr[], int n){
        int ans = 0;

        unordered_map<int, int> map;
        map[0] = 1; //add the sum 0 in the map

        int sum = 0;

        for(int i=0; i<n; i++){
            //if value at any index is 0, add -1 to the sum or add 1
            if(arr[i] == 0){
                sum += -1;
            } else{
                sum += 1;
            }

            //if the sum already exists in the map, add its frequency to the ans
            if(map.find(sum) != map.end()){
                ans += map[sum];
            }

            //update the frequency of the sum
            map[sum]++;
        }

        return ans;
    }
};