package HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static class Solution{
        public int[] twoSum(int[] nums, int target){
            Map<Integer, Integer> map = new HashMap<>();
            int[] ans = new int[2];

            for(int i=0; i<nums.length; i++){
                int first = nums[i];
                int sec = target - first;

                if(map.containsKey(sec)){
                    ans[0] = i;
                    ans[1] = map.get(sec);
                    break;
                }

                map.put(first, i);
            }
            return ans;
        }
    }

    public static void main(String[] args){
        int[] nums = {2,7,11,12};

        Solution solution = new Solution();

        int[] ans = solution.twoSum(nums, 9);

        System.out.println(Arrays.toString(ans));
    }
}
