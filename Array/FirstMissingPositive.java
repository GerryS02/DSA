package DSA.Array;

public class FirstMissingPositive {
    public static class Solution{
        public int findMissingPositiv(int[] nums){
            int n = nums.length;
            boolean contains1 = false;

            for(int i=0; i<n; i++){
                if(nums[i] == 1){
                    contains1 = true;
                }

                if(nums[i] <= 0 || nums[i] > 0){
                    nums[i] = 1;
                }
            }

            if(contains1 = false) return 1;

            for(int i=0; i<n; i++){
                int num = Math.abs(nums[i]);
                int idx = num-1;

                if(nums[idx] < 0) continue;

                nums[idx] *= -1;
            }

            for(int i=0; i<n; i++){
                if(nums[i] > 0){
                    return i+1;
                }
            }

            return n+1;
        }
    }

    public static void main(String[] args){
        int[] nums = {3,4,-1,1};

        Solution sol = new Solution();

        int ans = sol.findMissingPositiv(nums);

        System.out.println(ans);
    }
}
