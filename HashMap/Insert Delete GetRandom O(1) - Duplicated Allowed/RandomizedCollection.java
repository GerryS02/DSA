import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

class RandomizedCollection{

    HashMap<Integer, HashSet<Integer>> map; //use hashset to store the multiple indices of a value present in the list
    List<Integer> list;
    Random r;
    
    public RandomizedCollection(){
        map = new HashMap<>();
        list = new ArrayList<>();
        r = new Random();
    }

    public boolean insert(int val){
        boolean flag;
        HashSet<Integer> set;

        //if the value already exists int the map, get the set of indices
        if(map.containsKey(val)){
            set = map.get(val);
            flag = false;
        } else{
            set = new HashSet<>(); //if not, add a new set of indices
            flag = true;
        }

        //add the current size of list as the index for that value
        set.add(list.size());
        //add that value in the list
        list.add(val); 
        //update the map with the new set of indices
        map.put(val, set);

        return flag;
    }

    public boolean remove(int val){
        HashSet<Integer> set;

        //if the value is present in the map, get the set of indices or return false
        if(map.containsKey(val)){
            set = map.get(val);
        } else{
            return false;
        }

        int remIdx = -1;
        for(int i : set){
            remIdx = i; //get the index of one occurence to remove
            break;
        }

        set.remove(remIdx); //remove the index from the set
        map.put(val, set); //update the map with modified set

        //id no occurence of the vale exist -> remove that value from the set
        if(map.get(val).size() == 0){
            map.remove(val);
        }

        //remove the value from the list

        //if the value lies at the last index, remove directly
        if(remIdx == list.size()-1){
            list.remove(list.size()-1);
        } else{
            //if not, swap that index with last element and remove the last element
            list.set(remIdx, list.get(list.size()-1));
            list.remove(list.size()-1);

            //get the value that was moved from the last index in the list
            int newVal = list.get(remIdx);

            //get the set of indices from the map for that value
            HashSet<Integer> temp = map.get(newVal);

            temp.remove(list.size()); //remove the old index of the moved value
            temp.add(remIdx); //add the new index
            map.put(newVal, temp); //update the set int he map
        }

        return true;
    }

    public int getRandom(){ 
        //generate a random number within the range of the list size
        int randomIdx = r.nextInt(list.size());

        //return the value corresponding to that index
        return list.get(randomIdx);
    }
};