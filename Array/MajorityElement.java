package DSA.Array;

public class MajorityElement {
    public static class Solution{
        public int majorityelement(int[] nums){
            int freq = 0, ans = 0;
            int n = nums.length;

            for(int i=0; i<n; i++){
                if(freq == 0){
                    ans = nums[i];
                }

                if(nums[i] == ans){
                    freq++;
                } else{
                    freq--;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();

        int[] nums = {1,2,2,1,1};

        System.out.println("Majority Element: "+ solution.majorityelement(nums));
    }
}
