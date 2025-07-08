class Solution{
public: 
    int longestSequence(int[] arr){
        unordered_set<int> set;

        //add all the numbers to the set
        for(int val : arr){
            set.insert(val);
        }

        int maxLen = 0; //track the longest sequence length

        //for every number(val) in the set
        for(int val : set){
            //only if val-1 is not in the set
            if(set.find(val-1) == set.end()){
                int currLen = 1; //start a new sequence
                int currNum = val; //current number in the sequence

                //check for the next consecutive number to the current number
                while(set.find(currNum+1) != set.end()){
                    currLen++; //increment the length
                    currNum++; //move to the next number
                }

                //update the maximum length of the sequence wrt to the current sequence
                maxLen = max(currLen, maxLen);
            }
        }

        return maxLen;
    }
};