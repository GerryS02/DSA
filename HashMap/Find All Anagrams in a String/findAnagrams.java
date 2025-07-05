import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class findAnagrams {
    
    public List<Integer> findAnagrams(String s, String p){
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> pmap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        if(s.length() < p.length()){
            return ans;
        }

        for(int i=0; i<p.length(); i++){
            char ch = p.charAt(i);
            pmap.put(ch, pmap.getOrDefault(ch, 0) +1);
        }

        for(int i=0; i<p.length(); i++){
            char ch = s.charAt(i);
            smap.put(ch, smap.getOrDefault(ch, 0) +1);
        }

        int i = p.length();

        while(i < s.length()){
            if(smap.equals(pmap)){
                ans.add(i - p.length());
            }

            char nextCh = s.charAt(i);
            smap.put(nextCh, smap.getOrDefault(nextCh, 0) +1);

            char prevCh = s.charAt(i - p.length());
            if(smap.get(prevCh) == 1){
                smap.remove(prevCh);
            } else{
                smap.put(prevCh, smap.get(prevCh) -1);
            }

            i++;
        }

        if(smap.equals(pmap)){
            ans.add(i - p.length());
        }

        return ans;
    }
};
