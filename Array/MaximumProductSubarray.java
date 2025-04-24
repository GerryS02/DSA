package DSA.Array;

public class MaximumProductSubarray {
    public static class Solution{
        public int maxProduct(int[] nums){
            int n = nums.length;

            int maxProd = nums[0], minProd = nums[0];
            int ans = nums[0];

            for(int i=1; i<n; i++){
                if(nums[i] < 0){
                    int temp = maxProd;
                    maxProd = minProd;
                    minProd = temp;
                }

                maxProd = Math.max(nums[i], nums[i]* maxProd);
                minProd = Math.min(nums[i], nums[i]* minProd);

                ans = Math.max(ans, maxProd);
            }
            return ans;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        int[] test1 = {2,3,-2,0};
        int[] test2 = {-2, 0,-1};
        int[] test3 = {0,2};

        System.out.println("Maximum Product of test1: "+ sol.maxProduct(test1));
        System.out.println("Maximum Product of test2: "+ sol.maxProduct(test2));
        System.out.println("Maximum Product of test3: "+ sol.maxProduct(test3));
    }
}
