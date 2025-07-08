import java.util.HashSet;

class LongestConsecutive {
    public int longestSequence(int[] arr){
        //hashset to store every elemnt 
        HashSet<Integer> set = new HashSet<>();

        //add all the numbers to the set
        for(int val : arr){
            set.add(val);
        }

        int maxLen = 0; //maximum length of the sequence 

        //loop through each unique element in the set
        for(int val : set){
            //if the number is the first of the sequence
            if(!set.contains(val-1)){
                int currLen = 1; //length of the current sequence
                int currNum = val; //current number of the sequence

                //keep checking if the next consecutive number to the current number is in the set
                while(set.contains(currNum+1)){
                    currLen++; //increment the current length
                    currNum++; //check for the next number
                }

                maxLen = Math.max(currLen, maxLen); //if this length is longer, update the maximum length
            }
        }

        return maxLen;
    }
};
