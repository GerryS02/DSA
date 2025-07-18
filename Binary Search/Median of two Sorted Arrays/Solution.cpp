#include<iostream>
#include <vector>
#include <climits>

using namespace std;

class Solution{
public:
    double findMedianSortedArrays(vector<int>& arr1, vector<int>& arr2){

        if(arr1.size() < arr2.size()){
            swap(arr1, arr2);
        }

        int start  = 0;
        int end = arr1.size();
        int totalLen = arr1.size() + arr2.size();

        while(start <= end){
            int mid1 = start + (end-start)/2;
            int mid2 = (totalLen+1)/2 - mid1;

            int left1 = (mid1 == 0) ? INT_MIN : arr1[mid1 -1];
            int right1 = (mid1 == arr1.size()) ? INT_MAX : arr1[mid1];
            int left2 = (mid2 == 0) ? INT_MIN : arr2[mid2 -1];
            int right2 = (mid2 == arr2.size()) ? INT_MAX : arr2[mid2];

            if(left1 <= right2 && left2 <= right1){
                double median;

                if(totalLen % 2 == 0){
                    int leftMax = max(left1, left2);
                    int rightMin = min(right1, right2);

                    median = (leftMax + rightMin)/2.0;
                } else{
                    int leftMax = max(left1, left2);

                    median  = leftMax;
                }

                return median;
            } else if(left1 > right2){
                end = mid1-1;
            } else{
                start = mid1+1;
            }
        }

        return 0.0;
    }
};

int main(){
    Solution sol;
    vector<int> arr1 = {1,4,8};
    vector<int> arr2 = {3,5,10};

    double median = sol.findMedianSortedArrays(arr1, arr2);

    cout<<"Median: "<<median<<endl;
}