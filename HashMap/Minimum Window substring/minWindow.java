import java.util.HashMap;

public class minWindow {

    public String minWindow(String s, String t){
        String ans = "";

        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) +1);
        }

        int count = 0;
        int desiredCount = t.length();

        HashMap<Character, Integer> map1 = new HashMap<>();

        int i = -1, j = -1;

        while(true){
            boolean flag1 = false;
            boolean flag2 = false;
            //aquire
            while(i<s.length()-1 && count < desiredCount){
                i++;

                char ch = s.charAt(i);
                map1.put(ch, map1.getOrDefault(ch, 0) +1);

                if(map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0)){
                    count++;
                }

                flag1 = true;
            }

            //collect and release
            while(j<i && count == desiredCount){
                String pAns = s.substring(j+1, i+1);

                if(ans.length() == 0 || pAns.length() < ans.length()){
                    ans = pAns;
                }

                j++;

                char ch = s.charAt(j);
                if(map1.get(ch) == 1){
                    map1.remove(ch);
                } else{
                    map1.put(ch, map1.getOrDefault(ch, 0) -1);
                }

                if(map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0)){
                    count--;
                }

                flag2 = true;
            }

            if(flag1 == false && flag2 == false){
                break;
            }
        }

        return ans;
    }
}
