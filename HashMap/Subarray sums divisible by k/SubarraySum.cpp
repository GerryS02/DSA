#include <vector>
#include <unordered_map>

class Solution{
public: 
    int subarraysDivByK(vector<int> &arr, int k){
        int count = 0; //count the number of subarrays with sum divisible by k 
        int rem = 0; //store the value of reminder
        int sum = 0; 

        unordered_map<int, int> m;
        //initialize the map with 0 -> 1 to handle subarrays starting from index 0
        m[0] = 1;

        for(int i=0; i<arr.size(); i++){
            //update the sum with current element
            sum += arr[i];

            //calculate the reminder for that sum
            rem = sum % k;

            //if rem is -ve, adjust it to +ve value b/w 0 and k-1
            if(rem < 0){
                rem += k;
            }

            //check if rem has been seen before
            if(m.find(rem) != m.end()){
                count += m[rem];  //add the freq of the rem to the count
                m[rem]++;   //update the freq
            } else{
                m[rem] = 1; //otherwise, initialize it to 1
            }

        }
        
        return count; 
    }
};