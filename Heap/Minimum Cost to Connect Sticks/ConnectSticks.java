import java.util.PriorityQueue;

public class ConnectSticks {
    public int connectSticks(int[] arr){
        //priority queue to get the smallest sticks first
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //add all the sticks to the queue
        for(int stick : arr){
            pq.add(stick);
        }

        int totCost = 0; //total cost of connecting the sticks

        //until one stick left, combine two smallest sticks
        while(pq.size() > 1){
            //take out two smallest sticks
            int s1 = pq.remove();
            int s2 = pq.remove();

            //cost to connect two sticks
            int cost = s1 + s2;

            //add to the total cost
            totCost += cost;

            //add the new stick back to the queue
            pq.add(cost);
        }

        return totCost;
    }

    public static void main(String[] args){
        ConnectSticks cs = new ConnectSticks();

        int[] sticks = {1,5,9,11,12,50,30,2,6};
        int totalCost = cs.connectSticks(sticks);

        System.out.println(totalCost);
    }
}
