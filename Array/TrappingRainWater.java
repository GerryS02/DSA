package DSA.Array;

public class TrappingRainWater {
    public static class Solution{
        public int trap(int[] height){
            int n = height.length;
            int l = 0, r = n-1;  // two pointers
            int leftMax = 0, rightMax = 0;
            int ans = 0;

            while(l < r){
                leftMax = Math.max(leftMax, height[l]);
                rightMax = Math.max(rightMax, height[r]);

                if(leftMax < rightMax){
                    ans += leftMax - height[l];
                    l++;
                } else{
                    ans += rightMax - height[r];
                    r--;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args){
        int[] height = {4,2,0,3,2,5};

        Solution sol = new Solution();

        int result = sol.trap(height);

        System.out.println(result);
    }
}
