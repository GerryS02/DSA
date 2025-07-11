import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class EmployeeFreeTime{

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule){
        List<Interval> result = new ArrayList<>();
        
        //min-heap to store the current intervals we are processing
        PriorityQueue<Interval> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i.start));

        //add all intervals from all employees to the priority queue
        for(List<Interval> intervals : schedule){
            for(Interval interval : intervals){
                pq.offer(interval);
            }
        }

        Interval prev = pq.poll();

        while(!pq.isEmpty()){
            Interval curr = pq.poll();

            //if there's a gap between the current interval and the previous one, it's free time
            if(prev.end < curr.end){
                result.add(new Interval(prev.end, curr.start)); //store the free time gap
            }

            //merge intervals if they overlap or are continuous
            prev = new Interval(Math.max(prev.end, curr.end), prev.end);
        }

        return result;
    }
};