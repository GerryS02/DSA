import java.util.HashMap;

class Solution{
    long getSubstringWithEqual012(String str){
        int ans = 0;

        //initialize the counters to count 0, 1 and 2 characters
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;

        //start with an initial key. The key will represent the difference in counts between 1's and 0's, and 1's and 2's
        String key = (c1-c0) + "#" + (c1-c2);

        //hashMap to store the frequency of each (c1-c0, c1-c2) pair
        HashMap<String, Integer> map = new HashMap<>();
        //initially, the key with value 1 is put in the map to handle the case when a valid substring starts from the beginning.
        map.put(key, 1);

        for(int i=0; i<str.length(); i++){
            //get the current character
            char ch = str.charAt(i);

            //update the counters based on the character encountered
            if(ch == '0'){
                c0++;
            } else if(ch == '1'){
                c1++;
            } else{
                c2++;
            }

            //calculate the key for the curr substring
            key = (c1-c0) + "#" + (c1-c2);

            //if this key is seen before in the map
            if(map.containsKey(key)){
                //add the freq into the ans and increment the freq
                ans += map.get(key);
                map.put(key, map.get(key) +1);
            } else{
                map.put(key, 1); //or, put the freq = 1
            }
        }

        //return the number of substrings containing equal number of 0's, 1's, and 2's
        return ans;
    }
};