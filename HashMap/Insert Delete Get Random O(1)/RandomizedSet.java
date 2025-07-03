import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

class Randomizedset {
    // use hashmap to store values and their indices in the list
    HashMap<Integer, Integer> m;
    List<Integer> list;
    Random r;

    public Randomizedset(){
        m = new HashMap<>();
        list = new ArrayList<>();
        r = new Random();
    } 

    public boolean insert(int val){
        //if the value already exist in the map, we don't need to insert again -> 
        // return false
        if(m.containsKey(val)){
            return false;
        }

        //insert the value in the map, with it's index in the list
        m.put(val, list.size());
        //add that value at the end of the list
        list.add(val);

        return true;
    }

    public boolean delete(int val){
        //if the value do not exist, return false
        if(!m.containsKey(val)){
            return false;
        }
        
        //get the index of the value to be deleted
        int remidx = m.get(val);
        //delete that value from the hashmap
        m.remove(val);

        //if the value is the last element in the list, simply remove it
        if(remidx == list.size()-1){
            list.remove(list.size()-1);
            return true;
        }

        //otherwise, swap that element with the last element in the list
        list.set(remidx, list.get(list.size()-1));
        //remove the list element
        list.remove(list.size()-1);

        //update the hashmap to reflect the new index of the last element(which is swapped)
        m.put(list.get(remidx), remidx);

        return true;
    }

    public int getRandom(){
        //generate a random integer b/w 0 and list.size()-1
        int randomidx = r.nextInt(list.size());

        //return the random integer as index of the list 
        return list.get(randomidx);
    }
}
