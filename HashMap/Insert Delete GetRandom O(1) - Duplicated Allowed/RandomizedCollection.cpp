class RandomizedCollection{
public:

    //map where key is the value and the index is the set of indices where that value appears in the list
    unordered_map<int, unordered_set<int>> map;
    vector<int> list;

    RandomizedCollection(){}

    bool insert(int val){
        bool flag;
        unordered_set<int> set; //temporary set to store the indicies where val is found in the list

        //id the value is found in the map
        if(map.find(val) != map.end()){
            set = map[val]; //get the set od indicies where it appears
            flag = false; //it is not the first time inserting this val
        } else{
            flag = true; //it is the first time inserting this val
        }

        //add the index of the new value to the set of that value
        set.insert(list.size());
        list.push_back(val); //add that value to the list
        map[val] = set; //update the map with the modified set for that value

        return flag;
    }

    bool remove(int val){

        //if the value do not present in the map, return false
        if(map.find(val) == map.end()){
            return false;
        }

        //reference the set of indices where the val appears
        auto& set = map[val];
        //get the index of the one occurence of the value to remove it
        int remIdx = *set.begin();

        //remove that index from the set
        set.erase(remIdx);
        //update that set corresponding to the removed value in the map
        map[val] = set;

        //id there are no more occurence of that val, remove it from the map
        if(set.empty()){
            map.erase(val);
        }

        //if the val is present at the last of the list, simply pop it off
        if(remIdx == list.size()-1){
            list.pop_back();
        } else{
            //or, replace that val with the last element and then remove the last element
            list[remidx] = list.back();
            list.pop_back();

            //get the new value replaced from the last
            int newVal = list[remIdx];
            //update the map for the new val's index
            map[newVal].erase(list.size());
            map[newVal].insert(remIdx);
        }

        return true;
    }

    int getRandom(){//get a random index in the range of size of list
        int randomIdx = rand() % list.size();

        //return the value corresponding to that index in the list
        return list[randomIdx];
    }
};