package DSA.ResursionAndBacktacking;

import java.util.ArrayList;
import java.util.List;

public class PermutationCombination {
    public static class Solution{
        public String getPermutations(int n, int k){
            List<Integer> numbers = new ArrayList<>();
            int[] fact = new int[n+1];
            StringBuilder result = new StringBuilder();

            fact[0] = 1;
            for(int i=1; i<=n; i++){
                numbers.add(i);
                fact[i] = i* fact[i-1];
            }

            k--;

            for(int i=1; i<=n; i++){
                int index = k / fact[n-i];

                result.append(numbers.get(index));
                numbers.remove(index);
                
                k = k % fact[n-i];
            }
            return result.toString();
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        
        System.out.println(sol.getPermutations(3, 3));
        System.out.println(sol.getPermutations(4, 9));
    }
}
