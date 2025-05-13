package DSA.RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static class Solution{
        public List<List<Integer>> permute(int[] nums){
            List<List<Integer>> ans = new ArrayList<>();
            getPerms(nums, 0, ans);
            return ans;
        }

        private void getPerms(int[] nums, int idx, List<List<Integer>> ans) {
            if(idx == nums.length){
                List<Integer> perms = new ArrayList<>();

                for(int num : nums){
                    perms.add(num);
                }
                ans.add(perms);
                return;
            }

            for(int i=idx; i<nums.length; i++){
                swap(nums, idx, i);
                getPerms(nums, idx+1, ans);

                swap(nums, idx, i); //backtracking
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args){
        int[] nums = {1,2,3};

        Solution sol = new Solution();

        List<List<Integer>> result = sol.permute(nums);

        for(List<Integer> perm : result){
            System.out.println(perm);
        }
    }
}
