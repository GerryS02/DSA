import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class findAnagrams {
    
    public List<Integer> findAnagrams(String s, String p){
        //hashmaps to stroe the freq of characters of 's' and 'p'
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> pmap = new HashMap<>();
        //list to store the starting indices of anagrams
        List<Integer> ans = new ArrayList<>();

        //if 's' is shorter than 'p,' no anagrams are possible
        //so return the empty list
        if(s.length() < p.length()){
            return ans;
        }

        //fill the pamp with the frequencies of the characters
        for(int i=0; i<p.length(); i++){
            char ch = p.charAt(i);
            pmap.put(ch, pmap.getOrDefault(ch, 0) +1); //add or update the count in the map
        }

        //fill the smap with the frequencies of the first window of 's'
        for(int i=0; i<p.length(); i++){
            char ch = s.charAt(i);
            smap.put(ch, smap.getOrDefault(ch, 0) +1);
        }

        //index i will tracj the right boundry of the window
        int i = p.length();

        //slide the window over 's' and check for anagrams
        while(i < s.length()){
            //if the current window in 's' is an anagram in 'p'
            if(smap.equals(pmap)){
                ans.add(i - p.length()); //add the starting index to the ans
            }

            //slide the window to the right by adding the next character
            char nextCh = s.charAt(i);
            smap.put(nextCh, smap.getOrDefault(nextCh, 0) +1);

            //remove the character that is sliding out of the window
            char prevCh = s.charAt(i - p.length());
            //if the freq of the character is 1, remove it from the map
            if(smap.get(prevCh) == 1){
                smap.remove(prevCh);
            } else{
                smap.put(prevCh, smap.get(prevCh) -1); //or decrease its freq
            }

            i++; //increment to the next character in 's'
        }

        //after the loop, check for the last window
        if(smap.equals(pmap)){
            ans.add(i - p.length());
        }

        //return the ans
        return ans;
    }
};
