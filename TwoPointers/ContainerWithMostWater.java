package TwoPointers;

public class ContainerWithMostWater {
    public static class Solution{
        public int maxArea(int[] height){
            int n = height.length;
            int left = 0, right = n-1;
            int maxWater = 0;

            while(left < right){
                int width = right - left;
                int ht = Math.min(height[left], height[right]);
                
                int area = width* ht;
                maxWater = Math.max(maxWater, area);

                if(left < right){
                    left++;
                } else{
                    right--;
                }
            }
            return maxWater;
        }

        public static void main(String[] args){
            int[] height1 = {1,8,6,2,5,4,8,3,7};
            int[] height2 = {1,1};

            Solution ans = new Solution();

            System.out.println(ans.maxArea(height1));
            System.out.println(ans.maxArea(height2));
        }
    }
}
