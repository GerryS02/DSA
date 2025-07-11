import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> left;  //max-heap -> to store the smallest set of values
    PriorityQueue<Integer> right;  //min-heap -> to store the largest half od values

    public MedianFinder(){
        //initalize the max-heap using reverse order comparator
        left = new PriorityQueue<>(Collections.reverseOrder());  
        right = new PriorityQueue<>(); 
    }

    public void add(int val){
        //if the number is larger than the smallest in the right heap
        if(right.size() > 0 && val > right.peek()){
            right.add(val); //add the value to the right 
        } else{
            //otherwise, add to the left heap
            left.add(val);
        }

        //if left heap has 2 more elements, move the largest element from left to right
        if(left.size() - right.size() == 2){
            right.add(val);
        } else if(right.size() - left.size() == 2){
            //if right heap has 2 more elements, move the largest element from right to left
            left.add(val);
        }
    }

    public double findMedian(){
        //if left heap has more elements, the median is the top of the left heap
        if(left.size() > right.size()){
            return left.peek();
        } else if(right.size() > left.size()){
            //if right heap has more elements, the median is the top of the right heap
            return right.peek();
        } else{
            //if both heaps have the same size, the median is the average of the tops of both heaps
            return (left.peek() + right.peek()) / 2.0;
        }
    }
}
