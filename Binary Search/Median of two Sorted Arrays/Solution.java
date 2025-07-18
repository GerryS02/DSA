class Solution{
    public double findMedianSortedArrays(int[] arr1, int[] arr2){
        //ensure arr1 is smaller than arr2
        if(arr1.length < arr2.length){
            int[] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }

        int start = 0; //start index of arr1
        int end = arr1.length; //end index of arr1
        int totalLen = arr1.length + arr2.length; //total length of both arrays

        //binary seach to find the correct partition
        while(start <= end){
            //get partition index for arr1 (left side of arr1)
            int mid1 = start + (end-start)/2;
            //get partition index for arr2 (left side of arr2)
            int mid2 = (totalLen+1)/2 - mid1;

            //find max values on the left side and min values on the right side of both arrays
            int left1 = (mid1 == 0) ? Integer.MIN_VALUE : arr1[mid1 - 1];
            int right1 = (mid1 == arr1.length) ? Integer.MAX_VALUE : arr1[mid1];
            int left2 = (mid2 == 0) ? Integer.MIN_VALUE : arr2[mid2 - 1];
            int right2 = (mid2 == arr2.length) ? Integer.MAX_VALUE : arr2[mid2];

            //check for valid partition
            if(left1 <= right2 && left2 <= right1){
                double median = 0.0;

                //if the total length of both arrays is even
                if(totalLen % 2 ==0){
                    //median is the average of middle two elements
                    int leftMax = Math.max(left1, left2); //get max of left elements
                    int rightMin = Math.min(right1, right2); //get min of right elements

                    median = (leftMax + rightMin) / 2.0;
                } else{
                    //if the total length is odd, there will be more elements in the left
                    //the median is the max of the left side
                    int leftMax = Math.max(left1, left2);

                    median = leftMax;
                }

                return median;
            } //adjust the search range based on the partition
            else if(left1 > right2){ 
                end = mid1 -1; //move the partition in nums1 to the left
    
            } else{ //(left2 > right2)
                start = mid1 +1; //move the partition in nums1 to the right
            }
        }

        return 0.0;
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        int arr1[] = {1,4,8};
        int arr2[] = {3,5,10};

        double median = sol.findMedianSortedArrays(arr1, arr2); //(4+5)/2 = 4.5

        System.out.println("Median: " + median);
    }
};