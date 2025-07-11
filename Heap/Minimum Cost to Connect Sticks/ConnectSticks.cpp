class ConnectSticks{
public:
    int connectSticks(vector<int>& arr){
        //min heap to store the sticks
        priority_queue<int, <vector<int>, greater<int>> pq;

        //add all sticks to the queue
        for(int stick : arr){
            pq.push(stick);
        }

        //track the total cost
        int totCost = 0;

        //combine sticks while there's more than one stick left
        while(pq.size() > 1){
            //get the two smallest sticks
            int s1 = pq.top();
            pq.pop();

            int s2 = pq.top();
            pq.pop();

            //get the cost of adding these sticks by adding the sticks together
            int cost - s1 + s1;

            //add that cost to the total cost
            totCost += cost;

            //push back the new stick to the queue
            pq.push(cost);
        }

        return totCost; //return the total cost
    }

};