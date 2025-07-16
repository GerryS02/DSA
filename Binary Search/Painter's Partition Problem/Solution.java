class Solution{
    public int minTimeToPaint(int[] boards, int m, int t){
        //find the maximum board length and the sum of all boards
        int max= 0;
        int sum = 0;

        for(int board : boards){
            sum += board;
            max = Math.max(board, max);
        }

        int lo = max;
        int hi = sum;

        int ans = 0; //store the result (minimum time)

        while(lo <= hi){
            //calculate the middle time value
            int mid = lo + (hi-lo)/2;

            //check if it is possible to paint all boards with the current time limit (mid)
            if(isPossible(boards, m, mid)){
                ans =  mid; //if it is possible, store the result
                hi = mid-1; //try to reduce the time
            } else{
                lo = mid+1; //if it's not possible, increase the time
            }
        }

        //return the minimum time to paint all boards (multiply by t to account for time per unit of board)
        return ans*t;
    }

    public static boolean isPossible(int[] arr, int m, int mid){
        int painter = 1; //start with one painter
        int time = 0; //time spend by curr painter

        //iterate over all boards to see if we can assign them within the time limit (mid)
        for(int i=0; i<arr.length; i++){
            time += arr[i];  //add the current board's length to the time

            //if the time exceeds the limit (mid), assign the current board to the next painter
            if(time > mid){
                painter++; //use another painter
                time = arr[i]; //reset time for the new painter, starting with this board
            }
        }

        //return true if we used fewer than or equal to m painters
        return painter <= m;
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        int[] boards = {40,30,10,20};
        int t = 4;
        int m = 2;

        int ans = sol.minTimeToPaint(boards, m, t);

        System.out.println("Minimum time taken to paint all boards: " + ans);
    }
};