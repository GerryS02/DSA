package String;

public class ValidPalidrone {
    public static class Solution{
        public boolean isPalindrome(String s) {

            s = s.trim(); // remove the space
            s = s.toLowerCase(); // convert to lower case
            s = s.replaceAll("[^a-zA-Z0-9]", ""); // remove non-alphabaric characters
    
            //initialize the first and last element with pointers
            int front = 0;
            int last = s.length() -1;
    
            while(front < last){
                if(s.charAt(front) != s.charAt(last)){
                    return false;
                }
                front ++;
                last --;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String test1 = "A man, a plan, a canal: Panama";
        String test2 = "Taylor Swift";
        String test3 = " ";

        System.out.println("Test 1: " + sol.isPalindrome(test1));  // true
        System.out.println("Test 2: " + sol.isPalindrome(test2));  // false
        System.out.println("Test 3: " + sol.isPalindrome(test3));  // true
    }
}
