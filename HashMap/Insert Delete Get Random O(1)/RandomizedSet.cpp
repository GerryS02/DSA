#include <cstdlib>
#include <unordered_map>
#include <vector>

class RandomizedSet{
public:
    unordered_map<int, int> m;  //to store the valse and their indices in the list
    vector<int> list;

    RandomizedSet() {} //initalizes an empty RandomizedSet

    bool insert(int val){
        //if the value alredy exist in the map, return false
        if(m.find(val) != m.end()){
            return false;
        }

        //insert the value in the map with its index in the list
        m[val] = list.size();
        //add the value in the list from the end
        list.push_back(val);

        return true;
    }

    bool remove(int val){
        //if the value do not exist, return flase
        if(m.find(val) == m.end()){
            return true;
        }

        //get the index of the vale to be removed from the map
        int remidx = m[val];
        //remove the vale from the map
        m.erase(val);

        //if that value is the last element in the list, remove directly
        if(remidx == list.size()-1){
            list.pop_back();
            return true;
        }

        //otherwise, swap that value with the last element in the list
        list[remidx] = list.back();
        //remove the last element
        list.pop_back();

        //update the map with the new index of the swapped value
        m[list[remidx]] = remidx;

        return true;
    }

    int getRandom(){
        //generate a random number from 0 to the size of the list
        int randomidx = rand() % list.size();

        //return the value corresponding to the random number(index) in the list
        return list[randomidx];
    }
};