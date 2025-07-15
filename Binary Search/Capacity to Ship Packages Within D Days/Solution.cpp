#include<iostream>
#include <vector>

using namespace std;

class Solution{
public: 
    int shipWithinDays(vector<int>& weights, int days){
        int sum = 0;  //store the total weight of all items
        int maxWt = 0; //store the maximum weight of a single item

        //find the sum of all the weights and the maximum item weight
        for(int val : weights){
            sum += val;
            maxWt = max(val, maxWt);
        }

        //if the number of days is the same as the number of items, the answer is simply the heaviest item
        if(weights.size() == days) return maxWt;

        int lo = maxWt; //lower bound for the ship capacity is the max weight of a single item
        int hi = sum; //upper bound for the ship capacity is the total weight

        int ans = 0;

        //perform binary search to find the minimum ship capacity that allows shipping within 'days' days
        while(lo <= hi){
            //calculate the mid capacity for the ship
            int mid = lo + (hi-lo)/2;

            //check if it's possible to ship within the given days with the current capacity 'mid'
            if(isPossible(weights, mid, days)){
                ans = mid; //record this as the current best solution
                hi = mid-1; //try to find a smaller possible ship capacity
            } else{
                lo = mid+1; //if not, increase the ship capacity to a larger value
            }
        }

        return ans;
    }

    bool isPossible(vector<int>& arr, int mid, int days){
        int day = 1;
        int sum = 0;

        for(int i=0; i<arr.size(); i++){
            sum += arr[i];

            if(sum > mid){
                day++;
                sum = arr[i];
            }
        }

        return day <= days;
    }
};

int main(){
    Solution sol;

    vector<int> wt1 = {3,2,2,4,1,4};
    vector<int> wt2 = {1,2,3,4,5,6,7,8,9,10};

    cout<<sol.shipWithinDays(wt1,3)<<endl;
    cout<<sol.shipWithinDays(wt2,5)<<endl;
}