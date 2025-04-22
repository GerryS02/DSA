package DSA.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static class Solution{
        public List<List<Integer>> threeSum(int[] nums) {
            int n = nums.length;
            List<List<Integer>> ans = new ArrayList<>();
    
            Arrays.sort(nums);
    
            for(int i=0; i<n; i++){
                int j = i+1, k = n-1;
    
                if(i>0 && nums[i] == nums[i-1]) continue;
    
                while(j<k){
                    int sum = nums[i]+nums[j]+nums[k];
    
                    if(sum < 0){
                        j++;
                    } else if(sum > 0){
                        k--;
                    } else{
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        j++;
                        k--;
    
                        while(j<k && nums[j] == nums[j-1]) j++;
                    }
    
                } 
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = sol.threeSum(nums);

        System.out.println("Triplets that sum to zero:");
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}
