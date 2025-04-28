package DSA.Array;

import java.util.Arrays;

public class NextGreaterElement3 {
    public static class Solution{
        public int nextGreaterElement(int n){
            char[] digits = String.valueOf(n).toCharArray();
            int len = digits.length;

            int i = len-2;
            while(i>=0 && digits[i] >= digits[i+1]){
                i--;
            }

            if(i<0) return -1;

            int j = i-1;
            while(digits[j] <= digits[i]){
                j--;
            }

            swap(digits, i, j);
            Arrays.sort(digits, i+1, len);

            long ans = Long.parseLong(new String(digits));

            if(ans <= Integer.MAX_VALUE){
                return (int) ans;
            } else{
                return -1;
            }
        }

        public void swap(char[] arr, int i, int j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args){
        
    }
}
