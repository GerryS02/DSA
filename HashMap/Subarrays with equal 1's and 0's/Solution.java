import java.util.HashMap;

class solution{
    public int countSubarrWithEqualZeroAndOne(int arr[], int n){
        int ans = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1); //initaialize the sum 0 with freq 1
        int sum = 0;

        //check for every value in the arr
        for(int val : arr){
            //if value is 0 add -1 to the sum
            if(val == 0){
                sum += -1;
            } else{
                sum += 1; //otherwisw, add +1
            }

            //if that sum already exist in the map (repeated)
            if(map.containsKey(sum)){
                //add the frequency of the sum to the ans
                ans += map.get(sum);
                //update the frequency
                map.put(sum, map.get(sum) +1);
            } else{
                map.put(sum, 1); //otherwise put the freq = 1
            }
        }

        return ans;
    }

};