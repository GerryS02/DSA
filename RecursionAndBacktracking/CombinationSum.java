package DSA.RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum {
    public static class Solution{
        private Set<List<Integer>> s = new HashSet<>();

        public void getCombinations(int[] arr, int idx, int target, List<List<Integer>> ans, List<Integer> combin){
            if(target < 0 || idx == arr.length){
                return;
            }

            if(target == 0){
                if(!s.contains(combin)){
                    ans.add(new ArrayList<>(combin));
                    s.add(new ArrayList<>(combin));
                }
                return;
            }

            combin.add(arr[idx]);

            // single inclusion
            getCombinations(arr, idx+1, target - arr[idx], ans, combin);
            //multiple inclusion
            getCombinations(arr, idx, target - arr[idx], ans, combin);

            combin.remove(combin.size() -1);

            //exclusion
            getCombinations(arr, idx+1, target, ans, combin);
        }

        public List<List<Integer>> combinationSum(int[] arr, int target){
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> combin = new ArrayList<>();

            getCombinations(arr, 0, target, ans, combin);

            return ans;
        }
    }

    public static void main(String[] args){
        int[] arr = {2,3,6,7};
        int target = 7;

        Solution sol = new Solution();

        System.out.println(sol.combinationSum(arr,target).toString());
    }
}
