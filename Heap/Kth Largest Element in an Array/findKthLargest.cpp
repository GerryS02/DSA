#include <iostream>
#include <queue>
#include <vector>
using namespace std;

class Solution{
public:
    int finfKthLargest(vector<int>& arr, int k){
        //make a  (min-heap) priority queue where smallest element is at the top
        priority_queue<int, vector<int>, greater<int>> pq;

        for(int i=0; i<arr.size(); i++){
            if(i<k){
                pq.push(arr[i]); //add the first k elements to the heap
            } else{
                //if the current element is greater than the smallest in the heap
                if(arr[i] > pq.top()){
                    pq.pop(); //remove the smallest element
                    pq.push(arr[i]); //add the current element
                }
            }
        }

        return pq.top(); //return the root (kth largest element)
    }

    int main(){
        Solution sol;

        vector<int> arr = {3,2,1,5,6,4};
        int k = 3;

        int ans = sol.finfKthLargest(arr, k);

        cout<<ans<<endl;

        return 0;
    }
};