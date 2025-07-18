#include<iostream>
#include <vector>

using namespace std;

class Solution{
public:
    bool search(vector<int>& arr, int target) {
        int lo = 0;
        int hi = arr.size()-1;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            
            if(target == arr[mid]){
                return true;
            } 
            //skip duplicates
            if (arr[lo] == arr[mid] && arr[mid] == arr[hi]) {
                lo++;
                hi--;
            }
            //left half is sorted
            else if(arr[lo] <= arr[mid]){
                if(target >= arr[lo] && target < arr[mid]){
                    hi = mid-1;
                } else{
                    lo = mid+1;
                }
            } 
            //right half is sorted
            else if(arr[mid] <= arr[hi]){
                if(target > arr[mid] && target <= arr[hi]){
                    lo = mid+1;
                } else{
                    hi = mid-1;
                }
            }
        }
        return false;
    }
};

int main(){
    Solution sol;

    vector<int> arr = {1,0,1,1,1};
    int target = 0;

    cout<<sol.search(arr, target)<<endl;
}
