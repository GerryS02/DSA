#include<iostream>
#include <vector>

using namespace std;

class Solution{
public:
    int minTimeToPaint(vector<int>& boards, int m, int t){
        int sum = 0, maxLen = 0;

        for(int board : boards){
            sum += board;
            maxLen = max(maxLen, board);
        }

        int lo = maxLen;
        int hi = sum;

        int ans = 0;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;

            if(isPossible(boards, m, mid)){
                ans = mid;
                hi = mid-1;
            } else{
                lo = mid+1;
            }
        }

        return ans*t;
    }

    bool isPossible(vector<int>& arr, int m, int mid){
        int painter = 1;
        int time = 0;

        for(int i=0; i<arr.size(); i++){
            time += arr[i];

            if(time > mid){
                painter++;
                time = arr[i];
            }
        }

        return painter <= m;
    }
};

int main(){
    Solution sol;

    vector<int> boards = {40,30,10,20};

    int m = 2;
    int t = 4;

    int ans = sol.minTimeToPaint(boards, m, t);

    cout<<"Minimum time taken to paint all boards: "<<ans<<endl;
}