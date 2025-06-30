import java.util.HashMap;

class Solution {
    public int subarraysDivByK(int[] arr, int k){
        int count =0; //store the num of subarrays divisible by k
        int rem = 0; //to store values of reminder
        int sum = 0;

        HashMap<Integer, Integer> m = new HashMap<>();
        //initialize rem 0 with frequency 1
        m.put(0,1);

        for(int i=0; i<arr.length; i++){
            //calculate the sum of current element
            sum += arr[i];

            //calculate the reminder of the surrent sum
            rem = sum % k;

            //if rem is -ve, make it +ve
            if(rem < 0){
                rem += k;
            }

            //if the rem alredy exist in the map
            if(m.containsKey(rem)){
                count += m.get(rem);  //add the frequency to the count
                m.put(rem, m.get(rem)+1);  //update the frequency
            } else{
                m.put(rem, 1); //if not, then initialize it with 1
            }
        }
        return count;
    }
}
