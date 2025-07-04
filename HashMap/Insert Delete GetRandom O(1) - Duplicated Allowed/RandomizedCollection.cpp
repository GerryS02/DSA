class RandomizedCollection{
public:

    unordered_map<int, unordered_set<int>> map;
    vector<int> list;

    RandomizedCollection(){}

    bool insert(int val){
        bool flag;
        unordered_set<int> set;

        if(map.find(val) != map.end()){
            set = map[val];
            flag = false;
        } else{
            flag = true;
        }

        set.insert(list.size());
        list.push_back(val);
        map[val] = set;

        return flag;
    }

    bool remove(int val){

        if(map.find(val) == map.end()){
            return false;
        }

        auto& set = map[val];
        int remIdx = *set.begin();

        set.erase(remIdx);
        map[val] = set;

        if(set.empty()){
            map.erase(val);
        }

        if(remIdx == list.size()-1){
            list.pop_back();
        } else{
            list[remidx] = list.back();
            list.pop_back();

            int newVal = list[remIdx];
            map[newVal].erase(list.size());
            map[newVal].insert(remIdx);
        }

        return true;
    }

    int getRandom(){
        int randomIdx = rand() % list.size();

        return list[randomIdx];
    }
};