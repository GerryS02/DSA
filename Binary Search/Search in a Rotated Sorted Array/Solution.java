class Solution{
    public int search(int[] arr, int target){
        int lo = 0; //start index of the array
        int hi = arr.length-1; //end index of the array

        while(lo <= hi){
            int mid = lo + (hi-lo)/2; //calc the middle index

            //if the middle element is the target, return its index
            if(target == arr[mid]){
                return mid;
            } 
            //check if left half is sorted
            else if(arr[lo] <= arr[mid]){
                //if the target is int left half
                if(target >= arr[lo] && target < arr[mid]){
                    hi = mid-1; //move the search to left half
                } else{
                    lo = mid+1; //move the serch to right half
                }
            }
            //otherwise, right half must be sorted
            else if(arr[mid] <= arr[hi]){
                //if the target is in the right half
                if(target > arr[mid] && target <= arr[hi]){
                    lo = mid+1; //move serch to right side
                } else{
                    hi = mid-1; //move serch to left side
                }
            }
        }

        return -1; //target not found
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        int arr[] = {4,5,6,7,0,1,2};
        int target = 4;

        System.out.println(sol.search(arr, target));
    }
};