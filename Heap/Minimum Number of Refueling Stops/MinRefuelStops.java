import java.util.Collections;
import java.util.PriorityQueue;

class Solution{
    public int minRefuelStops(int target, int startFuel, int[][] stations){

        //max-heap to the fuel amouns
        //always pick the biggest amount available
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int i = 0; //track the stations
        int stops = 0; //track the number of stops
        int disTravelled = startFuel; //how far we can go with the curr fuel

        //while we haven't reached the target
        while(disTravelled < target){
            //while the station is behind or at the curr distance
            while(i<stations.length && stations[i][0] <= disTravelled){
                pq.add(stations[i][1]); //save its fuel in the queue
                i++; //move to the next station
            }

            //if no fuel is available (queue is empty) -> return -1
            if(pq.size() == 0) return -1;

            //otherwise, refuel from the passed stations with the most fuel
            disTravelled += pq.remove(); //add that fuel to the curr distance
            stops++; //update the stops
        }

        return stops;
    }
};