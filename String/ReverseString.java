package DSA.String;

public class ReverseString {
    public static class Solution{
        public void reverseString(char[] s){

            for(int i=0; i<s.length/2; i++){
                //initilize the first and last elements
                int front = i;
                int back = s.length - 1 - i;

                // swap the elements
                char temp = s[front];
                s[front] = s[back];
                s[back] = temp;
            }

            System.out.println("Reversed String: "+ String.valueOf(s));
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        char[] input = {'h', 'e', 'l', 'l', 'o'};

        sol.reverseString(input);

    }
}
