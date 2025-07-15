#include <iostream>
#include <vector>

using namespace std;

class Solution{
public:

    bool isPossible(vector<int>& arr, int mid, int k){
        int st = 1;
        int sum = 0;

        for(int i=0; i<arr.size(); i++){
            sum += arr[i];

            if(sum > mid){
                st++;
                sum = arr[i];
            }
        }

        return st <= k;
    }

    int findPages(vector<int>& arr, int k){
        if(k > arr.size()) return -1;

        int sum = 0;
        int maxPages = 0;

        for(int val : arr){
            sum += val;
            maxPages = max(maxPages, val);
        }

        int lo = maxPages;
        int hi = sum;

        int ans;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;

            if(isPossible(arr, mid, k)){
                ans = mid;
                hi = mid-1;
            } else{
                lo = mid+1;
            }
        }

        return ans;
    }
};

int main(){
    Solution sol;

    vector<int> arr1 = {12, 34, 67, 90};
    int k1 = 2;
    cout << sol.findPages(arr1, k1) << endl;
}