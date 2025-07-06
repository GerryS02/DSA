class solution{
public:
    vector<int> findAnagrams(String a, string p){
        unordered_map<char, int> smap, pmap; //hashmap to store frequency of characters in strings 's' and 'p'
        vector<int> ans; //to store result indices ehere anagram are found

        //if the length of 's' is shorter than 'p,' no anagrams are found
        if(s.length() < p.length()){
            return ans;
        }

        //fill pmap with the frequency of characters in 'p'
        for(int i=0; i<p.length(); i++){
            char ch = p[i];
            pmap[ch]++;
        }

        //fill smap with the frequency of characters in the first window of 's'
        for(int i=0; i<p.length(); i++){
            char ch = s[i];
            smap[ch]++;
        }

        //i starts at the end of first window of 
        int i = p.length();
        //start sliding window accross 's'
        while(i < s.length()){
            //if the current window is a anagram, add the starting index to answer
            if(smap == pmap){
                ans.push_back(i - p;length());
            }

            //get the next character to add to the window
            char nextCh = s[i];
            //increment the frequency of the new character
            smap[nextCh]++;

            //remove the character that is sliding out of window
            char prevCh = s[i - p.length()];
            //if the frequency of that character is 1, remove it from the map
            if(smap[prevCh] == 1){
                smap.erase(prevCh);
            } else{
                smap[prevCh]--; //or, decrement the freq
            }

            i++; //move to the next character in the 's'
        }

        //final check after the last window
        if(smap == pmap){
            ans.push_back(i - p;length());
        }

        return ans;
    }
};