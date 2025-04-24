package DSA.Array;
import java.util.Arrays;

public class MergeSortedArrays {

    public static class solution{
        public void merge(int[] nums1, int m, int[] nums2, int n){

            int i = m - 1; // last index of nums1
            int j = n - 1; // last index of nums2
            int k = m + n - 1; // last index of merged nums1

            while(i>=0 && j>=0){

                //if current element of nums2 is greater, place it at the end of nums1
                if(nums1[i] < nums2[j]){
                    nums1[k--] = nums2[j--];
                } else{
                    nums1[k--] = nums1[i--];
                }
            }

            // if any element left in nums2, copy them to nums1
            while(j>=0){
                nums1[k--] = nums2[j--];
            }
        }
    }

    public static void main(String[] args) {
        solution solution =  new solution();

        int[] nums1 = {1,2,3,0,0,0,0};
        int[] nums2 = {2,5,6,7}; 
        int m = 7;
        int n = 4;

        solution.merge(nums1, m, nums2, n);

        System.out.println("Merged array: " + Arrays.toString(nums1));
        
        
    }
}
