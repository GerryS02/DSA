class Solution{
    public:

    long long getSubstringWithEqual012(string str){
        long ans = 0;

        int c0 = 0;
        int c1 = 0;
        int c2 = 0;

        //key to store the relative difference of 0, 1 and 2 

        // If we've seen the same difference (c1 - c0) and (c1 - c2) before, 
        // it means the substring between the current index and the previous index 
        // has an equal number of '0's, '1's, and '2's.

        string key = to_string(c1-c2) + "#" + to_string(c1-c2);

        unordered_map<string, int> map;
        map[key] = 1;

        for(int i=0; i<str.length(); i++){
            char ch = str[i];

            if(ch =='0'){
                c0++;
            } else if(ch =='1'){
                c1++;
            } else{
                c2++;
            }

            key = to_string(c1-c2) + "#" + to_string(c1-c2);

            if(map.find(key) != map.end()){
                ans += map[key];
            }

            map[key]++;

        }

        return ans;
    }
}