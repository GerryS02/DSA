#include <vector>
#include <queue>

class Solution{
public:
    int minRefuelStops(int target, int startFuel, vector<vector<int>>& stations){
        //priority queue to store the fuel capacity of stations we pass
        priority_queue<int> pq;

        int i = 0; //track the number of stations
        int stops = 0;  //counter for the number of refueling stops
        int disTravelled = startFuel; //the current distance we can travel, starting with the initial fuel

        //keep moving until reached the target
        while(disTravelled < target){
            //check all stations that we can reach with the current distance (disTravelled)
            while(i<stations.size() && stations[i][0] <= disTravelled){
                //push the fuel available at the current station into the priority queue
                pq.push(stations[i][1]);
                i++; //move to the next station
            }

            //if we cannot reach any more stations and can't reach the target, return -1

            if(pq.empty()) return -1;

            //take the station with the largest fuel capacity from the priority queue
            disTravelled += pq.top();
            pq.pop(); //remove the station from the queue as we are refueling there
            stops++; //increment the stops made
        }

        return stops;
    }
};