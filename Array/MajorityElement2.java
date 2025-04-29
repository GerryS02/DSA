package DSA.Array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    public static class Solution{
        public List<Integer> majorityElement(int[] nums){
            int n = nums.length;
            List<Integer> ans = new ArrayList<>();

            int freq;

            for(int i=0; i<n; i++){
                freq = nums[i];
                int count = 1;

                for(int j=i+1; j<n; j++){
                    if(freq == nums[j]){
                        count++;
                    }
                }

                if(count > (n/3) && !ans.contains(nums[i])){
                    ans.add(nums[i]);
                }
            }
            return ans;
        }

        public static void main(String[] args){
            int[] nums = {3,2,3};
            Solution sol = new Solution();

            List<Integer> result = sol.majorityElement(nums);

            System.out.println("Majority Element: "+ result);
            
        }
    }
}
