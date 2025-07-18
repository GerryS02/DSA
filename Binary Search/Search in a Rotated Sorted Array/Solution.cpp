#include<iostream>
#include <vector>

using namespace std;

class Solution{
public:

    int search(vector<int>& arr, int target) {
        int lo = 0;
        int hi = arr.size()-1;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;

            if(target == arr[mid]){
                return mid;
            } else if(arr[lo] <= arr[mid]){
                if(target >= arr[lo] && target < arr[mid]){
                    hi = mid-1;
                } else{
                    lo = mid+1;
                }
            } else if(arr[mid] <= arr[hi]){
                if(target > arr[mid] && target <= arr[hi]){
                    lo = mid+1;
                } else{
                    hi = mid-1;
                }
            }
        }
        return -1;
    }
};

int main(){
    Solution sol;

    vector<int> arr = {4,5,6,7,0,1,2};
    int target = 4;

    cout<<sol.search(arr, target)<<endl;
}