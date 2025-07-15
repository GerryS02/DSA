class Solution{
    public int shipWithinDays(int[] weights, int days){
        int sum = 0;
        int max = 0;

        for(int val : weights){
            sum += val;
            max = Math.max(val, max);
        }

        if(weights.length == days){
            return max;
        }

        int lo = max;
        int hi = sum;

        int ans = 0;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;

            if(isPossible(weights, mid, days)){
                ans = mid;
                hi = mid -1;
            } else{
                lo = mid +1;
            }
        }

        return ans;
    }

    public static boolean isPossible(int[] arr, int mid, int days){
        int day = 1;
        int sum = 0;

        for(int i=0; i<arr.length; i++){
            sum += arr[i];

            if(sum > mid){
                day++;
                sum = arr[i];
            }
        }

        return day <= days;
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        int[] weights = {3,2,2,4,1,4};
        int days = 3;

        int[] weights2 = {1,2,3,4,5,6,7,8,9,10};
        int days2 = 5;

        System.out.println(sol.shipWithinDays(weights, days));

        System.out.println(sol.shipWithinDays(weights2, days2));        
    }
};